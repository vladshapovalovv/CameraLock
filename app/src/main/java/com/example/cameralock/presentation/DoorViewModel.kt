package com.example.cameralock.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cameralock.domain.entity.Door
import com.example.cameralock.domain.usecase.ForceRefreshDoorsUseCase
import com.example.cameralock.domain.usecase.GetDoorsUseCase
import com.example.cameralock.domain.usecase.UpdateDoorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoorViewModel @Inject constructor(
    private val getDoorsUseCase: GetDoorsUseCase,
    private val updateDoorUseCase: UpdateDoorUseCase,
    private val forceRefreshDoorsUseCase: ForceRefreshDoorsUseCase
) : ViewModel() {

    private val _state = MutableLiveData<DoorState>()
    val state: LiveData<DoorState> = _state

    fun loadDoors() {
        _state.value = DoorState.Loading

        viewModelScope.launch(handleError) {

            val doors = getDoorsUseCase.invoke()

            if (doors.isNotEmpty()) {
                _state.value = DoorState.Content(doors)
            } else {
                DoorState.Error("Empty")
            }
        }
    }

    fun refreshDoors() {
        _state.value = DoorState.Loading

        viewModelScope.launch(handleError) {
            val doors = forceRefreshDoorsUseCase.invoke()

            if (doors.isNotEmpty()) {
                DoorState.Content(doors)
            } else {
                DoorState.Error("Empty")
            }
        }
    }

    fun editDoor(door: Door) {
        viewModelScope.launch(handleError) {
            updateDoorUseCase.invoke(door)
        }
    }


    private val handleError = CoroutineExceptionHandler { _, exception ->
        _state.value = DoorState.Error(exception.message ?: exception.toString())
    }
}