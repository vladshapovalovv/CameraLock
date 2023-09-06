package com.example.cameralock.domain.repository

import com.example.cameralock.domain.entity.Camera
import com.example.cameralock.domain.entity.Door

interface CameraRepository {

    suspend fun get(): List<Camera>

    suspend fun forceRefresh(): List<Camera>

}