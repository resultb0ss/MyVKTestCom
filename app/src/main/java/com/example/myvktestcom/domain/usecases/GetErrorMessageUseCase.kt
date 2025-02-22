package com.example.myvktestcom.domain.usecases

import com.example.myvktestcom.domain.repositories.VideoPlayerRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.StateFlow

class GetErrorMessageUseCase @Inject constructor(
    private val playerRepository: VideoPlayerRepository
) {

    operator fun invoke(): StateFlow<String?> = playerRepository.getErrorMessage()
}