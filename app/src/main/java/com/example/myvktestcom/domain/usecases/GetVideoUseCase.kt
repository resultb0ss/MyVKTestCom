package com.example.myvktestcom.domain.usecases

import com.example.myvktestcom.domain.models.Resource
import com.example.myvktestcom.domain.models.VideoEntity
import com.example.myvktestcom.domain.repositories.VideoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVideoUseCase @Inject constructor(
    private val videoRepository: VideoRepository
) {
    suspend fun execute(): Flow<Resource<List<VideoEntity>>> = videoRepository.getVideos()
}