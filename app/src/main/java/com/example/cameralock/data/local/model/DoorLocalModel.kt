package com.example.cameralock.data.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class DoorLocalModel : RealmObject {
    @PrimaryKey
    var _id: Int = 0
    var name: String = ""
    var room: String? = null
    var favorites: Boolean = false
    var snapshot: String? = null
}