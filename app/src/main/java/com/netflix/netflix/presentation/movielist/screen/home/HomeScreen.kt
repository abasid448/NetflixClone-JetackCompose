package com.netflix.netflix.presentation.movielist.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.netflix.netflix.presentation.movielist.MovieListViewModel
import com.netflix.netflix.presentation.movielist.components.MovieListScreen

@Composable
fun HomeScreen(
    viewModel: MovieListViewModel = hiltViewModel()
) {
    var scafoldstate = rememberScaffoldState()
    var scrollState = rememberScrollState()
    val navController = rememberNavController()

    val popularMovieState = viewModel.popularMovieState.value
    val trendingMovieState = viewModel.trendingMovieState.value
    val upcomingMovieState = viewModel.upcomingMovieState.value
    val topRatedMovieState = viewModel.topRatedMovieState.value

    Scaffold() {
        //Navigation(navController = navController)

        Column(
            modifier = Modifier
                .background(Color.Black)
                .verticalScroll(scrollState)
//                .verticalScroll(scrollState)
        ) {
            MovieCard()
            MovieListScreen("PopularMovies", popularMovieState)
            MovieListScreen("TrendingMovies", trendingMovieState)
            MovieListScreen("UpcomingMovies", upcomingMovieState)
            MovieListScreen("TopRatedMovies", topRatedMovieState)
        }

    }

}