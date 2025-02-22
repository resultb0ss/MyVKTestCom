package com.example.myvktestcom.domain.repositories

import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import kotlinx.coroutines.flow.StateFlow

interface VideoPlayerRepository {
    fun initializePlayer(context: Context, videoUrl: String)
    fun savePlayerState()
    fun releasePlayer()
    fun getPlayerState(): StateFlow<ExoPlayer?>
    fun getErrorMessage(): StateFlow<String?>
}