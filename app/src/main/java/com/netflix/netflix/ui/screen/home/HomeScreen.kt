package com.netflix.netflix.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen() {
    var scafoldstate = rememberScaffoldState()
    var scrollState = rememberScrollState()
    val navController = rememberNavController()
    Scaffold(scaffoldState = scafoldstate, bottomBar = {
//        BottomNavigationBar(
//            items = listOf(
//                BottomNavItem(
//                    name = "Home",
//                    route = "home",
//                    icon = Icons.Default.Home
//                ),
//                BottomNavItem(
//                    name = "Fast Laugh",
//                    route = "fast laugh",
//                    icon = Icons.Default.Settings
//                ),
//                BottomNavItem(
//                    name = "Search",
//                    route = "search",
//                    icon = Icons.Default.Search
//                ),
//                BottomNavItem(
//                    name = "Downloads",
//                    route = "downloads",
//                    icon = Icons.Default.ArrowDropDown
//                )
//            ), navController = navController, onItemClick = {
//                navController.navigate(it.route)
//            }


    }) {
//        Navigation(navController = navController)

        Column(
            modifier = Modifier
                .background(Color.Black)
                .verticalScroll(scrollState)
//                .verticalScroll(scrollState)
        ) {

            MovieCard()
            MovieCardList()


        }

    }

}