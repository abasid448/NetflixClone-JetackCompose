package com.netflix.netflix.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object FastLaugh : BottomBarScreen(
        route = "fastLaugh",
        title = "FastLaugh",
        icon = Icons.Default.Face
    )
    object Search : BottomBarScreen(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )

    object Downloads : BottomBarScreen(
        route = "downloads",
        title = "Downloads",
        icon = Icons.Default.ArrowDropDown
    )
}
