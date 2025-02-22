package com.example.myvktestcom.data.repositories

import android.content.Context
import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.example.myvktestcom.R
import com.example.myvktestcom.domain.repositories.VideoPlayerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class VideoPlayerRepositoryImpl @Inject constructor() : VideoPlayerRepository {

    private val _playerState = MutableStateFlow<ExoPlayer?>(null)
    private val _errorMessage = MutableStateFlow<String?>(null)
    private var currentPosition: Long = 0L

    override fun initializePlayer(context: Context, videoUrl: String) {
        if (_playerState.value == null) {
            val exoPlayer = ExoPlayer.Builder(context).build().also {
                val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
                it.setMediaItem(mediaItem)
                it.prepare()
                it.playWhenReady = true
                it.seekTo(currentPosition)
                it.addListener(object : Player.Listener {
                    override fun onPlayerError(error: PlaybackException) {
                        handleError(context, error)
                    }
                })
            }
            _playerState.value = exoPlayer
        }
    }

    override fun savePlayerState() {
        _playerState.value?.let {
            currentPosition = it.currentPosition
        }
    }

    override fun releasePlayer() {
        _playerState.value?.let { player ->
            player.pause()
            player.release()
        }
        _playerState.value = null
    }

    override fun getPlayerState(): StateFlow<ExoPlayer?> = _playerState

    override fun getErrorMessage(): StateFlow<String?> = _errorMessage

    private fun handleError(context: Context, error: PlaybackException) {
        val errorMessage = when (error.errorCode) {
            PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED -> {
                context.getString(R.string.network_connection_error)
            }

            PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND -> {
                context.getString(R.string.file_not_found_error)
            }

            PlaybackException.ERROR_CODE_DECODER_INIT_FAILED -> {
                context.getString(R.string.decoder_init_error)
            }

            else -> {
                context.getString(R.string.generic_playback_error)
            }
        }
        _errorMessage.value = errorMessage
    }
}