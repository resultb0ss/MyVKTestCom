package com.example.myvktestcom.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myvktestcom.domain.VideoEntity
import com.example.myvktestcom.presentation.screen.MainListScreen
import com.example.myvktestcom.ui.theme.MyVKTestComTheme

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

                MainListScreen(videos) { }

            }
        }
    }
}
