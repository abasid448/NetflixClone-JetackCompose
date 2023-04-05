package com.netflix.netflix.domain.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val movieId: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String
)
