package com.netflix.netflix.presentation.movielist.screen.downloads

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable



@Composable
fun DownloadScreen() {

    var scrollState = rememberScrollState()
    Scaffold(Modifier.padding(bottom = 40.dp)) {
        Column(
            modifier = Modifier
                .background(Color.Black)
                .verticalScroll(scrollState)
        ) {
            DownloadScreenTopBar()
            DownloadScreenTexts()
        }
    }

}