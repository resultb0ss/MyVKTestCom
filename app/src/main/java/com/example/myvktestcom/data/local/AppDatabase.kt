package com.example.myvktestcom.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myvktestcom.domain.models.VideoEntity

@Database(entities = [VideoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun videoDao(): VideoDao
}