package com.netflix.netflix.presentation.movielist.screen.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem (
    val name : String,
    val route : String,
    val icon : ImageVector
){
    object Home : BottomNavItem(
        route = "home",
        name = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomNavItem(
        route = "fastLaugh",
        name = "FastLaughs",
        icon = Icons.Default.Person
    )

    object Settings : BottomNavItem(
        route = "downloads",
        name = "Downloads",
        icon = Icons.Default.Settings
    )
}