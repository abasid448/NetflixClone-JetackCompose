package com.netflix.netflix.presentation.movielist.screen.welcome

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen() {
    val scope = rememberCoroutineScope()
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed, animationSpec = tween(
            durationMillis = 500, delayMillis = 0
        )
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    BottomSheetScaffold(scaffoldState = scaffoldState,
        sheetShape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
        sheetPeekHeight = 0.dp,
        sheetContent = {
            BottomSheetContent( )

        }) {
        Column(Modifier.background(Color.Black)) {
            Box(modifier = Modifier.weight(90f)) {
                ViewPager()
                WelcomeTopBar()
            }
            Box(
                modifier = Modifier
                    .weight(10f)
                    .padding(16.dp)
            ) {
                FullWidthButton(
                    contentColor = Color.White,
                    containerColor = Color.Red,
                    buttonText = "Get Started"
                ) {
                    scope.launch {
                        sheetState.expand()
                    }
                }
            }
        }

    }
}
