package com.example.myvktestcom.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myvktestcom.domain.models.Resource
import com.example.myvktestcom.domain.models.VideoEntity
import com.example.myvktestcom.domain.usecases.GetVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainListScreenViewModel @Inject constructor(
    private val getVideoUseCase: GetVideoUseCase
) : ViewModel() {

    private var _videos =
        MutableStateFlow<Resource<List<VideoEntity>>>(Resource.Success(emptyList()))
    val videos: StateFlow<Resource<List<VideoEntity>>> = _videos

    private var _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    init {
        loadVideos()
    }

    fun loadVideos() {
        viewModelScope.launch {
            _isRefreshing.value = true
            _videos.value = Resource.Loading()
            try {
                getVideoUseCase.execute().collect { resource ->
                    _videos.value = resource
                    _isRefreshing.value = false
                }
            } catch (e: Exception) {
                _videos.value = Resource.Error("Error: ${e.localizedMessage}")
                _isRefreshing.value = false
            }
        }
    }
}