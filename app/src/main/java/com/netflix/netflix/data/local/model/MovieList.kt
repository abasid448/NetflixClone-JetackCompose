package com.netflix.netflix.data.local.model

import com.netflix.netflix.data.local.model.Movie

data class MovieList(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)