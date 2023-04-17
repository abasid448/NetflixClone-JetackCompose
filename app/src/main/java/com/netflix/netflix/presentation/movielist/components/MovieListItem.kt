package com.netflix.netflix.presentation.movielist.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import com.netflix.netflix.R
import com.netflix.netflix.common.ApiConstants.IMAGE_BASE_UR
import com.netflix.netflix.data.local.model.Movie

@Composable
fun MovieListItem(
    movie: Movie, onItemClick: (Movie) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                onItemClick(movie)
            },
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(100.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = "${IMAGE_BASE_UR}/${movie.posterPath}", builder = {
                        placeholder(R.drawable.coil3)
                        crossfade(true)
                    }
                ),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
    }
}
