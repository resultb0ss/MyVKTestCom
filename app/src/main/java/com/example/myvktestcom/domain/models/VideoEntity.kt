package com.example.myvktestcom.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videos")
data class VideoEntity(
    @PrimaryKey val id: String = "0",
    val title: String,
    val thumbnail: String,
    val description: String = "00:20",
    val mp4Url: String
)