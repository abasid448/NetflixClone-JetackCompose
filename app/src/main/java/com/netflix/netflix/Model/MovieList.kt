package com.netflix.netflix.Model

import android.graphics.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<MovieResponse>
)