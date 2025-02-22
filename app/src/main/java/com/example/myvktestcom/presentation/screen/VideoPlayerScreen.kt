package com.example.myvktestcom.presentation.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
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

    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    var isTopAppBarVisible = remember { mutableStateOf(true) }

    LaunchedEffect(videoUrl) {
        playerViewModel.initializePlayer(context, videoUrl)
    }

    DisposableEffect(Unit) {
        onDispose {
            playerViewModel.savePlayerState()
            playerViewModel.releasePlayer()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                isTopAppBarVisible != isTopAppBarVisible
            }
    ) {
        Column(Modifier.background(color = Color.Black)) {

            if (isPortrait && isTopAppBarVisible.value) {
                TopAppBar(
                    title = { Text(text = context.getString(R.string.video_player_toolbar_title)) },
                    navigationIcon = {
                        IconButton(onClick = { onClick() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }

            player?.let {
                Media3AndroidView(player = it, isPortrait)
            }
        }
    }
}

