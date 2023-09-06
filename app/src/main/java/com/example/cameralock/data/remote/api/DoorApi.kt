package com.example.cameralock.data.remote.api

import com.example.cameralock.data.remote.api.ApiSettings.DOORS
import com.example.cameralock.data.remote.model.DoorRemoteModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class DoorApi @Inject constructor(
    private val client: HttpClient
) {
    suspend fun getDoors(): DoorRemoteModel = client.get(DOORS).body()
}