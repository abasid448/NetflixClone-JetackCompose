package com.netflix.netflix.api

import com.netflix.netflix.Model.MovieList
import com.netflix.netflix.Model.MovieResponse
import com.netflix.netflix.api.ApiConstants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("3/trending/all/day")
    suspend fun getTrendingMovies(
        @Query("api_key")
        apiKey: String = API_KEY
    ): Response<MovieResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey: String = API_KEY
    ): Response<MovieList>

    @GET("/movie/latest")
    suspend fun getLatestMovies(
        @Query("api_key")
        apiKey: String = API_KEY
    ): Response<MovieResponse>

    @GET("/movie/top_rated")
    suspend fun getMovies(
        @Query("api_key")
        apiKey: String = API_KEY
    ): Response<MovieResponse>


    @GET("/movie/upcoming")
    suspend fun upcomingMovies(
        @Query("api_key")
        apiKey: String = API_KEY
    ): Response<MovieResponse>
}