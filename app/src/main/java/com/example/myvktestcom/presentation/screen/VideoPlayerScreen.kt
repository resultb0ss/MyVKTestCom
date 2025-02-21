package com.example.myvktestcom.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myvktestcom.R
import com.example.myvktestcom.presentation.components.Media3AndroidView
import com.example.myvktestcom.presentation.viewmodels.VideoPlayerScreenViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoPlayerScreen(
    videoUrl: String,
    onClick: () -> Unit
) {
    val playerViewModel: VideoPlayerScreenViewModel = hiltViewModel()
    val context = LocalContext.current
    val player = playerViewModel.playerState.collectAsState().value

    LaunchedEffect(videoUrl) {
        playerViewModel.initializePlayer(context, videoUrl)
    }

    DisposableEffect(Unit) {
        onDispose {
            playerViewModel.savePlayerState()
            playerViewModel.releasePlayer()
        }
    }

    Column {
        TopAppBar(
            title = { Text(text = context.getString(R.string.video_player_toolbar_title)) },
            navigationIcon = {
                IconButton(onClick = { onClick() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )
        player?.let {
            Media3AndroidView(player = it)
        }
    }
}
