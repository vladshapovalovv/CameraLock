package com.example.cameralock.data.converter

import com.example.cameralock.data.remote.model.DoorRemoteModel
import com.example.cameralock.domain.entity.Door
import javax.inject.Inject

class DoorRemoteConverter @Inject constructor() {

    fun convert(from: DoorRemoteModel): List<Door> {
        return from.data.map { doorModel ->
            Door(
                name = doorModel.name,
                room = doorModel.room,
                id = doorModel.id,
                favorites = doorModel.favorites,
                snapshot = doorModel.snapshot
            )
        }
    }
}