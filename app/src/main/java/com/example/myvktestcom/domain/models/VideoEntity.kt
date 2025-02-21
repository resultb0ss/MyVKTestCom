package com.example.myvktestcom.domain

data class VideoEntity(
    val id: String = "0",
    val title: String,
    val thumbnail: String,
    val description: String,
    val mp4Url: String
)