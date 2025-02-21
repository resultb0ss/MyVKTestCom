package com.example.myvktestcom.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myvktestcom.domain.models.VideoEntity
import com.example.myvktestcom.presentation.navigation.AppNavigation
import com.example.myvktestcom.ui.theme.MyVKTestComTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyVKTestComTheme {
                val videos = listOf(VideoEntity("0","FireRain","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/thumbnail.jpg","00:20","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/mp4/source.mp4"),
                    VideoEntity("0","FireRain","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/thumbnail.jpg","00:20","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/mp4/source.mp4"),
                    VideoEntity("0","FireRain","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/thumbnail.jpg","00:20","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/mp4/source.mp4"),
                    VideoEntity("0","FireRain","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/thumbnail.jpg","00:20","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/mp4/source.mp4"),
                    VideoEntity("0","FireRain","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/thumbnail.jpg","00:20","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/mp4/source.mp4"),
                    VideoEntity("0","FireRain","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/thumbnail.jpg","00:20","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/mp4/source.mp4"),
                    VideoEntity("0","FireRain","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/thumbnail.jpg","00:20","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/mp4/source.mp4"),
                    VideoEntity("0","FireRain","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/thumbnail.jpg","00:20","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/mp4/source.mp4"),
                    VideoEntity("0","FireRain","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/thumbnail.jpg","00:20","https://vod.api.video/vod/vi7kTQuETwSv00H2eqbSOkaE/mp4/source.mp4"))

                AppNavigation(videos)

            }
        }
    }
}
