package com.netflix.netflix.domain.usecase.getmovies

import com.netflix.netflix.common.ApiConstants.MOVIE_CACHE_LIFETIME_IN_MINUTES
import com.netflix.netflix.common.Resource
import com.netflix.netflix.data.local.model.Movie
import com.netflix.netflix.data.local.model.MovieList
import com.netflix.netflix.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(categoryId: Int): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val lastFetchedTime = repository.getLastFetchedTimeFromApi()
            val currentTime = System.currentTimeMillis()
            if (!(lastFetchedTime != null &&
                        currentTime - lastFetchedTime <= (MOVIE_CACHE_LIFETIME_IN_MINUTES * 60 * 1000))
            ) {
                repository.clearAllMoviesFromDB()
            }
            val popularMovies = repository.getMovies(categoryId)
            if (popularMovies != null) {
                emit(Resource.Success(popularMovies))
            }
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        }
    }
}