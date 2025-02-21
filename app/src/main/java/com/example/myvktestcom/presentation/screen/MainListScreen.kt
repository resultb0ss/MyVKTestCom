package com.example.myvktestcom.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.myvktestcom.R
import com.example.myvktestcom.domain.VideoEntity
import com.example.myvktestcom.presentation.components.VideoListItemView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainListScreen(videos: List<VideoEntity>, onItemClick: (String) -> Unit) {
    val context = LocalContext.current
    Column {
        TopAppBar(
            title = { Text(text = context.getString(R.string.playlist_toolbar_title)) }
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(videos) { item ->
                VideoListItemView(item) {
                    onItemClick(item.mp4Url)
                }
            }
        }
    }

}