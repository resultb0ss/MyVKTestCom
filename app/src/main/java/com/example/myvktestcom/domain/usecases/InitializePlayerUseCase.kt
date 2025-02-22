package com.example.myvktestcom.domain.usecases

import android.content.Context
import com.example.myvktestcom.domain.repositories.VideoPlayerRepository
import javax.inject.Inject

class InitializePlayerUseCase @Inject constructor(
    private val playerRepository: VideoPlayerRepository
) {
    operator fun invoke(context: Context, videoUrl: String) {
        playerRepository.initializePlayer(context, videoUrl)
    }
}