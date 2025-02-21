package com.example.myvktestcom.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    videoPlayerContent: @Composable (videoUrl: String) -> Unit
) {

    NavHost(navController = navHostController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            homeScreenContent()
        }
        composable(
            route = Screen.VideoPlayerScreen.route,
            arguments = listOf(navArgument("videoUrl") { type = NavType.StringType })
        ) { backStackEntry ->
            val videoUrl = backStackEntry.arguments?.getString("videoUrl")
            if (videoUrl != null) {
                videoPlayerContent(videoUrl)
            }

        }
    }
}