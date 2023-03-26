package com.netflix.netflix.ui.screen.downloads

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun DownloadScreen() {

    var scaffoldState = rememberScaffoldState()
    var scrollState = rememberScrollState()
    Scaffold(scaffoldState = scaffoldState, modifier = Modifier.verticalScroll(scrollState)) {
        Column(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            DownloadScreenTopBar()
            DownloadScreenTexts()


        }


    }

}