package com.example.myvktestcom.domain.repositories

import com.example.myvktestcom.domain.models.Resource
import com.example.myvktestcom.domain.models.VideoEntity
import kotlinx.coroutines.flow.Flow

interface VideoRepository {
    suspend fun getVideos(): Flow<Resource<List<VideoEntity>>>
}