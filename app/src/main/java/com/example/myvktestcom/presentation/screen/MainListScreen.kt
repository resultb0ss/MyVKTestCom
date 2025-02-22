package com.example.myvktestcom.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myvktestcom.R
import com.example.myvktestcom.domain.models.Resource
import com.example.myvktestcom.presentation.components.CustomBox
import com.example.myvktestcom.presentation.components.VideoListItemView
import com.example.myvktestcom.presentation.viewmodels.MainListScreenViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainListScreen(
    viewModel: MainListScreenViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit
) {
    val context = LocalContext.current
    val videosState = viewModel.videos.collectAsState().value
    val snackbarHostState = remember { SnackbarHostState() }
    val isRefreshing = viewModel.isRefreshing.collectAsState().value

    LaunchedEffect(videosState) {
        if (videosState is Resource.Error) {
            val errorMessage =
                (videosState as Resource.Error).message ?: context.getString(R.string.unknown_error)
            snackbarHostState.showSnackbar(errorMessage)
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text(text = context.getString(R.string.playlist_toolbar_title)) }
            )
        }
    ) { paddingValues ->

        PullToRefreshBox(
            isRefreshing = isRefreshing,
            onRefresh = { viewModel.loadVideos() },
            modifier = Modifier.fillMaxSize()
        ) {
            when (videosState) {
                is Resource.Loading -> {
                    CustomBox(paddingValues) {
                        CircularProgressIndicator()
                    }
                }

                is Resource.Success -> {
                    val videos = (videosState as Resource.Success).data
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        videos?.let { videoList ->
                            items(videoList) { video ->
                                VideoListItemView(video) {
                                    onItemClick(video.mp4Url)
                                }
                            }
                        }
                    }
                }

                is Resource.Error -> {
                    CustomBox(paddingValues) {
                        Text(text = context.getString(R.string.error_loading_data))
                    }
                }
            }
        }
    }
}