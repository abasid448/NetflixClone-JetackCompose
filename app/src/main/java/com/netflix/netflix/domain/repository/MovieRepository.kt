package com.netflix.netflix.domain.repository

import com.netflix.netflix.domain.model.MovieList
import retrofit2.Response

interface MovieRepository {
    suspend fun getMovies(categoryId: Int): Response<MovieList>
}