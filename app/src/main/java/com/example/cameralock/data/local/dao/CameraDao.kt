package com.example.cameralock.data.local.dao

import com.example.cameralock.data.local.model.CameraLocalModel
import io.realm.kotlin.Realm
import javax.inject.Inject

class CameraDao @Inject constructor(
    private val realm: Realm
) {
    fun get(): List<CameraLocalModel> {
        return realm.query(CameraLocalModel::class).find()
    }

    suspend fun set(cameras: List<CameraLocalModel>) {
        return realm.write {
            cameras.map { copyToRealm(it) }
        }
    }
}