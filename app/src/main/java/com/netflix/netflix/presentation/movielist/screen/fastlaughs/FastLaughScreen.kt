package com.netflix.netflix.presentation.movielist.screen.fastlaughs

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable

@Composable
fun FastLaughScreen(){

    var scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState) {

        FastLaughViewPager()
    }

}