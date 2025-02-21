package com.example.myvktestcom.presentation.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.myvktestcom.domain.models.VideoEntity
import com.example.myvktestcom.presentation.screen.MainListScreen
import com.example.myvktestcom.presentation.screen.VideoPlayerScreen

@Composable
fun AppNavigation(videos: List<VideoEntity>) {

    val navHostController = rememberNavController()

    AppNavGraph(
        navHostController = navHostController,
        homeScreenContent = {
            MainListScreen(videos) { videoUrl ->
                navHostController.navigate(
                    Screen.VideoPlayerScreen.route.replace(
                        "{videoUrl}",
                        Uri.encode(videoUrl)
                    )
                )
            }
        },
        videoPlayerContent = { videoUrl ->
            VideoPlayerScreen(videoUrl) { navHostController.navigateUp() }
        }
    )
}

