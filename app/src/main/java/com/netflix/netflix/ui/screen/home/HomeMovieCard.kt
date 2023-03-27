package com.netflix.netflix.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.netflix.netflix.R


@Composable
fun MovieCard() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.poster2),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(470.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0f to Color.Black,
                        0.5f to Color.Transparent,
                        1.5f to Color.Black
                    )

                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                , Arrangement.SpaceAround, Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier
                        .size(60.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_add_24),
                        contentDescription = "",
                        modifier = Modifier.size(25.dp)
                    )
                    Text(text = "My List", color = Color.White)

                }

                Button(
                    onClick = { },
                    modifier = Modifier,
                    shape = RoundedCornerShape(10),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.play2),
                        contentDescription = "Image",
                        modifier = Modifier
                            .height(15.dp)
                            .width(15.dp)

                    )
                    Text(text = "  play", fontSize = 20.sp)
                }

                Column(
                    modifier = Modifier
                        .size(60.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_info_24),
                        contentDescription = "",
                        modifier = Modifier.
                        size(25.dp)
                    )
                    Text(text = "My Info", color = Color.White)

                }

            }
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(verticalArrangement = Arrangement.Top) {
                HomeScreenTopBar()
                HomeScreenTopBar2()
            }
        }

    }


}