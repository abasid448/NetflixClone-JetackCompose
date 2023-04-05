package com.netflix.netflix.presentation

import android.graphics.Movie
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.rememberNavController
import com.netflix.netflix.presentation.movielist.screen.navigation.BottomNavItem
import com.netflix.netflix.presentation.movielist.screen.navigation.BottomNavigationBar
import com.netflix.netflix.presentation.movielist.screen.navigation.Navigation
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
                val navController = rememberNavController()
                Scaffold(bottomBar = {
                    BottomNavigationBar(
                        items = listOf(
                            BottomNavItem(
                                name = "",
                                route = "home",
                                icon = Icons.Default.Home
                            ),
                            BottomNavItem(
                                name = " ",
                                route = "fast laugh",
                                icon = Icons.Default.Face
                            ),
                            BottomNavItem(
                                name = "",
                                route = "search",
                                icon = Icons.Default.Search
                            ),
                            BottomNavItem(
                                name = "",
                                route = "downloads",
                                icon = Icons.Default.KeyboardArrowDown
                            )
                        ), navController = navController, onItemClick = {
                            navController.navigate(it.route)
                        })

                }) {
                    Navigation(navController = navController)
                }
            }

            }
        }
    }

