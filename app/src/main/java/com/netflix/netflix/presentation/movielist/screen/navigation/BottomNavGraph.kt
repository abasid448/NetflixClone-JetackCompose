//package com.netflix.netflix.presentation.movielist.screen.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.netflix.netflix.presentation.movielist.screen.downloads.DownloadScreen
//import com.netflix.netflix.presentation.movielist.screen.fastlaughs.FastLaughScreen
//import com.netflix.netflix.presentation.movielist.screen.home.HomeScreen
//import com.netflix.netflix.presentation.movielist.screen.search.SearchScreen
//
//@Composable
//fun BottomNavGraph(navController: NavHostController) {
//    NavHost(
//        navController = navController,
//        startDestination = BottomBarScreen.Home.route
//    ) {
//        composable(route = BottomBarScreen.Home.route) {
//            HomeScreen()
//        }
//        composable(route = BottomBarScreen.Search.route) {
//            SearchScreen()
//        }
//        composable(route = BottomBarScreen.FastLaugh.route) {
//            FastLaughScreen()
//        }
//
//        composable(route = BottomBarScreen.Downloads.route) {
//                DownloadScreen()
//        }
//    }
//}