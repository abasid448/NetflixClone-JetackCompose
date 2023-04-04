package com.netflix.netflix.presentation

import android.graphics.Movie
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import com.netflix.netflix.presentation.movielist.screen.navigation.MainScreen
import com.netflix.netflix.presentation.ui.theme.NetFlixTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popMovies: MutableLiveData<List<Movie>> = _popularMovies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetFlixTheme {
                MainScreen()

            }
        }
    }
}
