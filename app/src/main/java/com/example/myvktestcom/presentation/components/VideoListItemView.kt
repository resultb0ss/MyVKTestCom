package com.example.myvktestcom.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.myvktestcom.domain.models.VideoEntity


@Composable
fun VideoListItemView(video: VideoEntity, onItemClick: () -> Unit) {

    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onItemClick() },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {

            Box(modifier = Modifier.size(width = 125.dp, height = 75.dp)) {
                AsyncImage(
                    model = video.thumbnail,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = video.description, color = Color.White, fontSize = 10.sp,
                    modifier = Modifier
                        .background(color = Color.Black, shape = RectangleShape)
                        .padding(1.dp)
                        .align(Alignment.BottomEnd)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = video.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

}