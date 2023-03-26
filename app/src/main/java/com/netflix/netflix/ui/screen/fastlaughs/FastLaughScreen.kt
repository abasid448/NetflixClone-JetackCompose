package com.netflix.netflix.ui.screen.fastlaughs

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