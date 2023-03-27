package com.netflix.netflix.repository

import com.netflix.netflix.api.RetrofitInstance

class MovieRepository {
    suspend fun getTrendingMovies() = RetrofitInstance.api.getTrendingMovies()
}