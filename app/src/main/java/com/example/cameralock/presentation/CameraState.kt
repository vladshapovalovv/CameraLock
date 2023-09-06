package com.example.cameralock.presentation

import androidx.compose.runtime.Composable
import com.example.cameralock.domain.entity.Camera

sealed interface CameraState {

    data object Loading : CameraState

    data class Content(val cameras: List<Camera>) : CameraState

    data class Error(val message: String) : CameraState

    @Composable
    fun onLoading(action: @Composable () -> Unit): CameraState {
        if (this is Loading) {
            action()
        }
        return this
    }

    @Composable
    fun onContent(action: @Composable (cameras: List<Camera>) -> Unit): CameraState {
        if (this is Content) {
            action(this.cameras)
        }
        return this
    }

    @Composable
    fun onError(action: @Composable (message: String) -> Unit): CameraState {
        if (this is Error) {
            action(this.message)
        }
        return this
    }
}