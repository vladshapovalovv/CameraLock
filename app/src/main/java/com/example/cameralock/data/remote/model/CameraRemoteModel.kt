package com.example.cameralock.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class CameraRemoteModel(
    val success: Boolean,
    val data: CameraData
) {

    @Serializable
    data class CameraData(
        val room: List<String>,
        val cameras: List<Camera>
    )

    @Serializable
    data class Camera(
        val name: String,
        val snapshot: String,
        val room: String?,
        val id: Int,
        val favorites: Boolean,
        val rec: Boolean
    )
}


