package com.netflix.netflix.presentation.movielist.screen.navigation

import android.content.Intent
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.netflix.netflix.presentation.Screen
import com.netflix.netflix.presentation.movieinfo.MovieDetailScreen
import com.netflix.netflix.presentation.movielist.screen.downloads.DownloadScreen
import com.netflix.netflix.presentation.movielist.screen.fastlaughs.FastLaughScreen
import com.netflix.netflix.presentation.movielist.screen.home.HomeScreen
import com.netflix.netflix.presentation.movielist.screen.search.SearchScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("fast laugh") {
            FastLaughScreen()
        }
        composable("search") {
            SearchScreen()
        }
        composable("downloads") {
            DownloadScreen()
        }
        composable(
            Screen.MovieDetailScreen.route + "/{movieId}",
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://abhijith-coding.com/{movieId}"
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(
                navArgument("movieId"){
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { entry ->
            MovieDetailScreen(movieId = entry.arguments?.getInt("movieId"))
        }
    }

}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>, navController: NavHostController,
    modifier: Modifier = Modifier, onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(modifier = modifier, backgroundColor = Color.Black, elevation = 5.dp) {
        items.forEach() { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(selected = selected, onClick = {
                onItemClick(item)
            }, selectedContentColor = Color.White, unselectedContentColor = Color.Gray, icon = {
                Icon(imageVector = item.icon, contentDescription = item.name)
            }
            )
            if (selected) {
                Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
            }
        }
    }

}