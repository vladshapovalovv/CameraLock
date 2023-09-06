package com.example.cameralock.data.local.dao

import com.example.cameralock.data.local.model.DoorLocalModel
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import javax.inject.Inject

class DoorDao @Inject constructor(
    private val realm: Realm
) {

    fun get(): List<DoorLocalModel> {
        return realm.query(DoorLocalModel::class).find()
    }

    suspend fun set(doors: List<DoorLocalModel>) {
        realm.write {
            doors.map { copyToRealm(it) }
        }
    }

    suspend fun update(door: DoorLocalModel){
        realm.write {
            val queriedDoor = query<DoorLocalModel>(query = "_id == $0", door._id).first().find()
            queriedDoor?.name= door.name
            queriedDoor?.favorites = door.favorites
        }
    }

}