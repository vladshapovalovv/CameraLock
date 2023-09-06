package com.example.cameralock.data.remote.api

import com.example.cameralock.data.remote.api.ApiSettings.CAMERA_DATA
import com.example.cameralock.data.remote.model.CameraRemoteModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class CameraApi @Inject constructor(
    private val client: HttpClient
) {
    suspend fun getCameraData(): CameraRemoteModel = client.get(CAMERA_DATA).body()
}