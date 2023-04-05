package com.netflix.netflix.presentation.movielist

import com.netflix.netflix.domain.model.Movie

data class MovieListState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error: String = ""
)
