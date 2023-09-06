package com.example.cameralock.domain.usecase

import com.example.cameralock.domain.entity.Door
import com.example.cameralock.domain.repository.DoorRepository
import javax.inject.Inject

class UpdateDoorUseCase @Inject constructor(
    private val repository: DoorRepository
) : suspend (Door) -> Unit {
    override suspend fun invoke(door: Door) {
        repository.update(door)
    }
}