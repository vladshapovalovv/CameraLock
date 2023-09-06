package com.example.cameralock.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
class DoorRemoteModel(
    val success: Boolean,
    val data: List<DoorModel>

) {
    @Serializable
    data class DoorModel(
        val name: String,
        val room: String? = null,
        val id: Int,
        val favorites: Boolean,
        val snapshot: String? = null
    )
}