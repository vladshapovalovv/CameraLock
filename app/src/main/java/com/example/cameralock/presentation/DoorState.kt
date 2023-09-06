package com.example.cameralock.presentation

import androidx.compose.runtime.Composable
import com.example.cameralock.domain.entity.Door

sealed interface DoorState {

    data object Loading : DoorState

    data class Content(val doors: List<Door>) : DoorState

    data class Error(val message: String) : DoorState

    @Composable
    fun onLoading(action: @Composable () -> Unit): DoorState {
        if (this is DoorState.Loading) {
            action()
        }
        return this
    }

    @Composable
    fun onContent(action: @Composable (doors: List<Door>) -> Unit): DoorState {
        if (this is DoorState.Content) {
            action(this.doors)
        }
        return this
    }

    @Composable
    fun onError(action: @Composable (message: String) -> Unit): DoorState {
        if (this is DoorState.Error) {
            action(this.message)
        }
        return this
    }
}