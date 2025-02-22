package com.example.myvktestcom.domain.usecases

import com.example.myvktestcom.domain.repositories.VideoPlayerRepository
import jakarta.inject.Inject

class SavePlayerStateUseCase @Inject constructor(
    private val playerRepository: VideoPlayerRepository
) {
    operator fun invoke() {
        playerRepository.savePlayerState()
    }
}