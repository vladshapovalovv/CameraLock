package com.example.cameralock.domain.usecase

import com.example.cameralock.domain.entity.Camera
import com.example.cameralock.domain.repository.CameraRepository
import javax.inject.Inject

class GetCamerasUseCase @Inject constructor(
    private val repository: CameraRepository
) : suspend () -> List<Camera> by repository::get