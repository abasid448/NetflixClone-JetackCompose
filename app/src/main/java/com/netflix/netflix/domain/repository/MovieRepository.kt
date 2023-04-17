package com.netflix.netflix.domain.repository

import com.netflix.netflix.data.local.model.Movie
import com.netflix.netflix.data.local.model.MovieList
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MovieRepository {
    suspend fun getMovies(categoryId: Int): List<Movie>?
    suspend fun clearAllMoviesFromDB()

    suspend fun getMovie(movieId:Int): Flow<Movie?>

    fun getLastFetchedTimeFromApi():Long
}