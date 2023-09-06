package com.example.cameralock.data.converter

import com.example.cameralock.data.remote.model.CameraRemoteModel
import com.example.cameralock.domain.entity.Camera
import javax.inject.Inject

class CameraRemoteConverter @Inject constructor() {

    fun convert(from: CameraRemoteModel): List<Camera> {
        return from.data.cameras.map { remoteCamera ->
            Camera(
                remoteCamera.name,
                remoteCamera.snapshot,
                remoteCamera.room,
                remoteCamera.id,
                remoteCamera.favorites,
                remoteCamera.rec
            )
        }
    }
}