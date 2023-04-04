package com.netflix.netflix.data.remote

import com.netflix.netflix.common.ApiConstants.API_KEY
import com.netflix.netflix.domain.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("trending/movie/day")
    suspend fun getTrendingTodayMovies(
        @Query("api_key")
        apiKey: String = API_KEY
    ): Response<MovieList>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey: String = API_KEY
    ): Response<MovieList>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key")
        apiKey: String = API_KEY
    ): Response<MovieList>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key")
        apiKey: String = API_KEY
    ): Response<MovieList>
}