package com.example.cameralock.data.converter

import com.example.cameralock.data.local.model.DoorLocalModel
import com.example.cameralock.domain.entity.Door
import org.mongodb.kbson.ObjectId
import javax.inject.Inject

class DoorLocalConverter @Inject constructor() {

    fun convert(from: Door): DoorLocalModel {
        return DoorLocalModel().apply {
            _id = from.id
            name = from.name
            room = from.room
            favorites = from.favorites
            snapshot = from.snapshot
        }
    }

    fun revert(from: DoorLocalModel): Door {
        return Door(
            name = from.name,
            room = from.room,
            id = from._id.toString().toInt(),
            favorites = from.favorites,
            snapshot = from.snapshot
        )
    }
}