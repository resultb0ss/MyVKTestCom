package com.example.myvktestcom.presentation.navigation

sealed class Screen(
    val route: String
) {

    object MainScreen: Screen(MAIN_SCREEN)
    object VideoPlayerScreen: Screen(VIDEO_PLAYER_SCREEN)

    private companion object {
        const val MAIN_SCREEN = "main_screen"
        const val VIDEO_PLAYER_SCREEN = "video_player/{videoUrl}"
    }
}