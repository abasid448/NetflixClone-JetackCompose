package com.netflix.netflix.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieCategory(
    @PrimaryKey(autoGenerate = false)
    val categoryId:Int,
    val category: String
)