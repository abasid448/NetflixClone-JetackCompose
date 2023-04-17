package com.netflix.netflix.data.repository

import android.content.SharedPreferences
import android.util.Log
import com.netflix.netflix.common.ApiConstants.POPULAR_MOVIES
import com.netflix.netflix.common.ApiConstants.TOP_RATED_MOVIES
import com.netflix.netflix.common.ApiConstants.TRENDING_MOVIES
import com.netflix.netflix.common.ApiConstants.UPCOMING_MOVIES
import com.netflix.netflix.data.local.MovieDao
import com.netflix.netflix.data.local.model.Movie
import com.netflix.netflix.data.local.model.relation.MovieCategoryCrossRef
import com.netflix.netflix.data.remote.MoviesApi
import com.netflix.netflix.data.local.model.MovieList
import com.netflix.netflix.data.sharedpreference.SharedPreferenceHelper
import com.netflix.netflix.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MoviesApi, private val movieDao: MovieDao, private
    val sharedPreferences: SharedPreferenceHelper
) : MovieRepository {
    val TAG = "MovieRepositoryImpl"


    override suspend fun getMovies(categoryId: Int): List<Movie>? {
        return getMoviesFromDatabase(categoryId)
    }

    override suspend fun clearAllMoviesFromDB() {
        movieDao.clearAllMovies()
    }

    override suspend fun getMovie(movieId:Int): Flow<Movie?> {
        return movieDao.getMovie(movieId)
    }

    private suspend fun getMoviesFromDatabase(categoryId: Int): List<Movie> {
        var movieList = ArrayList<Movie>()

        try {
            var movieCategoryWithMovies = movieDao.getMoviesOfCategory(categoryId)
            for (item in movieCategoryWithMovies) {
                movieList.addAll(item.movies)
            }
        } catch (exception: Exception) {
            Log.i(TAG, "getMoviesFromDatabase: ${exception.message}")
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList.addAll(getMoviesFromApi(categoryId))
            saveMoviesToDatabase(movieList, categoryId)
        }
        return movieList
    }

    private suspend fun getMoviesFromApi(categoryId: Int): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = getMoviesOfCategoryFromApi(categoryId)
            val body = response.body()

            if (body != null) {
                movieList = body.results
            }
        } catch (exception: Exception) {
            Log.i(TAG, "getMoviesFromDatabase: ${exception.message}")
        }
        setLastFetchedTime(System.currentTimeMillis())
        return movieList
    }

    private fun saveMoviesToDatabase(movies: List<Movie>, categoryId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.insertMovies(movies)
            val crossRef = ArrayList<MovieCategoryCrossRef>()
            for (movie in movies) {
                crossRef.add(
                    MovieCategoryCrossRef(movieId = movie.movieId, categoryId = categoryId)
                )
            }
            movieDao.insertMovieCategoryCrossRefs(crossRef)
        }
    }

    private suspend fun getMoviesOfCategoryFromApi(categoryId: Int): Response<MovieList> {
        val response: Response<MovieList> = when (categoryId) {
            POPULAR_MOVIES -> movieApi.getPopularMovies()
            TRENDING_MOVIES -> movieApi.getTrendingTodayMovies()
            UPCOMING_MOVIES -> movieApi.getUpcomingMovies()
            TOP_RATED_MOVIES -> movieApi.getTopRatedMovies()
            else -> movieApi.getPopularMovies()
        }
        return response
    }

    private fun setLastFetchedTime(currentTime: Long) {
        sharedPreferences.setLastFetchedTime(currentTime)
    }

    override fun getLastFetchedTimeFromApi(): Long {
        return sharedPreferences.getLastFetchedTime()
    }
}