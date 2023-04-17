package com.netflix.netflix.common

import com.netflix.netflix.data.local.model.MovieCategory

object ApiConstants {
    const val API_KEY = "cf49ba936a72c4adb878acc1fea63109"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_BASE_UR = "https://image.tmdb.org/t/p/w500/"

    const val MOVIE_CACHE_LIFETIME_IN_MINUTES = 30

    const val movieId = "movieId"

    // Movie Categories.
    const val POPULAR_MOVIES = 1
    const val TRENDING_MOVIES = 2
    const val UPCOMING_MOVIES = 3
    const val TOP_RATED_MOVIES = 4


    val movieCategories = listOf(
        MovieCategory(POPULAR_MOVIES, "Popular Movies"),
        MovieCategory(TRENDING_MOVIES, "Trending Movies"),
        MovieCategory(UPCOMING_MOVIES, "Upcoming Movies"),
        MovieCategory(TOP_RATED_MOVIES, "Top rated Movies"),
    )
}

