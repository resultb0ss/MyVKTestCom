package com.example.myvktestcom.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.exoplayer.ExoPlayer
import com.example.myvktestcom.domain.usecases.GetErrorMessageUseCase
import com.example.myvktestcom.domain.usecases.GetPlayerStateUseCase
import com.example.myvktestcom.domain.usecases.InitializePlayerUseCase
import com.example.myvktestcom.domain.usecases.ReleasePlayerUseCase
import com.example.myvktestcom.domain.usecases.SavePlayerStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoPlayerScreenViewModel @Inject constructor(
    private val initializePlayerUseCase: InitializePlayerUseCase,
    private val savePlayerStateUseCase: SavePlayerStateUseCase,
    private val releasePlayerUseCase: ReleasePlayerUseCase,
    private val getPlayerStateUseCase: GetPlayerStateUseCase,
    private val getErrorMessageUseCase: GetErrorMessageUseCase
) : ViewModel() {

    val playerState: StateFlow<ExoPlayer?> = getPlayerStateUseCase()
    val errorMessage: StateFlow<String?> = getErrorMessageUseCase()

    fun initializePlayer(context: Context, videoUrl: String) {
        viewModelScope.launch {
            try {
                initializePlayerUseCase(context, videoUrl)
            } catch (e: Exception) {
                //Могу поставить лог сюда
            }
        }
    }

    fun savePlayerState() {
        viewModelScope.launch {
            savePlayerStateUseCase()
        }
    }

    fun releasePlayer() {
        viewModelScope.launch {
            releasePlayerUseCase()
        }
    }
}