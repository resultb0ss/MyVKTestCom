package com.example.myvktestcom.domain.usecases

import com.example.myvktestcom.domain.repositories.VideoPlayerRepository
import javax.inject.Inject

class ReleasePlayerUseCase @Inject constructor(
    private val playerRepository: VideoPlayerRepository
) {
    operator fun invoke() {
        playerRepository.releasePlayer()
    }
}