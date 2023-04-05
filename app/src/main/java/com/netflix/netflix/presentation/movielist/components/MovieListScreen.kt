package com.netflix.netflix.presentation.movielist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.netflix.netflix.presentation.movielist.MovieListState

@Composable
fun MovieListScreen(
    title:String,
    movieListState: MovieListState
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .height(250.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )
        LazyRow {
            items(movieListState.movies) { movie ->
                MovieListItem(movie = movie)
            }
        }
        if (movieListState.error.isNotBlank()) {
            Text(
                text = movieListState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
        }
        if (movieListState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }


}