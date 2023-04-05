package com.netflix.netflix.data.repository

import com.netflix.netflix.common.ApiConstants.POPULAR_MOVIES
import com.netflix.netflix.common.ApiConstants.TOP_RATED_MOVIES
import com.netflix.netflix.common.ApiConstants.TRENDING_MOVIES
import com.netflix.netflix.common.ApiConstants.UPCOMING_MOVIES
import com.netflix.netflix.data.remote.MoviesApi
import com.netflix.netflix.domain.model.MovieList
import com.netflix.netflix.domain.repository.MovieRepository
import retrofit2.Response
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(
    private val api: MoviesApi
) : MovieRepository {
    val TAG = "MovieRepositoryImpl"

    override suspend fun getMovies(categoryId: Int): Response<MovieList> {
        lateinit var response: Response<MovieList>
        when (categoryId) {
            POPULAR_MOVIES -> response = api.getPopularMovies()
            TRENDING_MOVIES -> response = api.getTrendingTodayMovies()
            UPCOMING_MOVIES -> response = api.getUpcomingMovies()
            TOP_RATED_MOVIES -> response = api.getTopRatedMovies()
        }
        return response
    }
}