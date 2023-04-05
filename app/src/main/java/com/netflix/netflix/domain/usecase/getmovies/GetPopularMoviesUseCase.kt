package com.netflix.netflix.domain.usecase.getmovies

import android.util.Log
import com.netflix.netflix.common.Resource
import com.netflix.netflix.domain.model.MovieList
import com.netflix.netflix.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(categoryId: Int): Flow<Resource<MovieList>> = flow {
        try {
            emit(Resource.Loading())
            val popularMovies = repository.getMovies(categoryId)
            if (popularMovies.body() != null) {
                emit(Resource.Success(popularMovies.body()!!))
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