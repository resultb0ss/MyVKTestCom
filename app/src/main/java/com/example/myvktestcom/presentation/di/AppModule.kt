package com.example.myvktestcom.presentation.di

import com.example.myvktestcom.data.repositories.VideoPlayerRepositoryImpl
import com.example.myvktestcom.domain.repositories.VideoPlayerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideVideoPlayerRepository(): VideoPlayerRepository {
        return VideoPlayerRepositoryImpl()
    }
}