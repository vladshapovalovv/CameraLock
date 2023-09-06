package com.example.cameralock.domain.usecase

import com.example.cameralock.domain.entity.Door
import com.example.cameralock.domain.repository.DoorRepository
import javax.inject.Inject

class GetDoorsUseCase @Inject constructor(
    private val repository: DoorRepository
) : suspend () -> List<Door> by repository::get