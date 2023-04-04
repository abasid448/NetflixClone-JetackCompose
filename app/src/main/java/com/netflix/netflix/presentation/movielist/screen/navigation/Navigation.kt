package com.netflix.netflix.presentation.movielist.screen.navigation

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.netflix.netflix.presentation.movielist.screen.downloads.DownloadScreen
import com.netflix.netflix.presentation.movielist.screen.fastlaughs.FastLaughScreen
import com.netflix.netflix.presentation.movielist.screen.home.HomeScreen
import com.netflix.netflix.presentation.movielist.screen.search.SearchScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("Home") {
            HomeScreen()
        }
        composable("Scenes") {
            FastLaughScreen()
        }
        composable("Search") {
            SearchScreen()
        }
        composable("Downloads") {
            DownloadScreen()
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
            }, selectedContentColor = Color.Green, unselectedContentColor = Color.Gray, icon = {
                Icon(imageVector = item.icon, contentDescription = item.name)
            }
            )
            if (selected){
                Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
            }
        }
    }

}