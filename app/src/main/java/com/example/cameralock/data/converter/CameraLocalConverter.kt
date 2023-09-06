package com.example.cameralock.data.converter

import com.example.cameralock.data.local.model.CameraLocalModel
import com.example.cameralock.domain.entity.Camera
import javax.inject.Inject

class CameraLocalConverter @Inject constructor() {

    fun convert(from: Camera): CameraLocalModel {
        return CameraLocalModel().apply {
            _id = from.id
            name = from.name
            room = from.room
            snapshot = from.snapshot
            favorites = from.favorites
            rec = from.rec
        }
    }

    fun revert(from: CameraLocalModel): Camera {
        return Camera(
            name = from.name,
            snapshot = from.snapshot,
            room = from.room,
            id = from._id,
            favorites = from.favorites,
            rec = from.rec
        )
    }
}
