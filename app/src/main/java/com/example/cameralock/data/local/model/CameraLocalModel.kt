package com.example.cameralock.data.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class CameraLocalModel : RealmObject {
    @PrimaryKey
    var _id: Int = 0
    var name: String = ""
    var room: String? = null
    var snapshot: String = ""
    var favorites: Boolean = false
    var rec: Boolean = false
}