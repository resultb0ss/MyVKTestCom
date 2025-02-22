package com.example.myvktestcom

import android.app.Application
import androidx.room.Room

import com.example.myvktestcom.data.local.AppDatabase
import com.example.myvktestcom.data.local.VideoDao
import com.example.myvktestcom.data.network.ApiInterface
import com.example.myvktestcom.data.repositories.VideoPlayerRepositoryImpl
import com.example.myvktestcom.data.repositories.VideoRepositoryImpl
import com.example.myvktestcom.domain.repositories.VideoPlayerRepository
import com.example.myvktestcom.domain.repositories.VideoRepository
import com.example.myvktestcom.presentation.di.AppModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@TestInstallIn(components = [SingletonComponent::class], replaces = [AppModule::class])
object FakeAppModule {

    @Provides
    @Singleton
    fun provideVideoPlayerRepository(): VideoPlayerRepository {
        return VideoPlayerRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return Room.inMemoryDatabaseBuilder(
            application,
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideVideoDao(database: AppDatabase): VideoDao {
        return database.videoDao()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://sandbox.api.video/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideVideoRepository(apiInterface: ApiInterface, videoDao: VideoDao): VideoRepository {
        return VideoRepositoryImpl(apiInterface, videoDao)
    }
}