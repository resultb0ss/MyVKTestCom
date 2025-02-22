package com.example.myvktestcom.domain.usecases

import androidx.media3.exoplayer.ExoPlayer
import com.example.myvktestcom.domain.repositories.VideoPlayerRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.StateFlow

class GetPlayerStateUseCase @Inject constructor(
    private val playerRepository: VideoPlayerRepository
) {
    operator fun invoke(): StateFlow<ExoPlayer?> = playerRepository.getPlayerState()
}