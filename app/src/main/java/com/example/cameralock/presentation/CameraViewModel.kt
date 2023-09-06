package com.example.cameralock.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cameralock.domain.usecase.GetCamerasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
    private val getCamerasUseCase: GetCamerasUseCase
) : ViewModel() {

    private val _state = MutableLiveData<CameraState>()
    val state: LiveData<CameraState> = _state

    fun loadCameras() {
        _state.value = CameraState.Loading

        viewModelScope.launch(handleError) {
            val cameras = getCamerasUseCase.invoke()
            if (cameras.isNotEmpty()) {
                _state.value = CameraState.Content(cameras)
            } else {
                _state.value = CameraState.Error("Data empty")
            }
        }
    }

    private val handleError = CoroutineExceptionHandler { _, exception ->
        _state.value = CameraState.Error(exception.message ?: exception.toString())
    }
}