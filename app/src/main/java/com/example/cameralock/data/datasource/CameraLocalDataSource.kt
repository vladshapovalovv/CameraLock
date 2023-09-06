package com.example.cameralock.data.datasource

import com.example.cameralock.data.converter.CameraLocalConverter
import com.example.cameralock.data.local.dao.CameraDao
import com.example.cameralock.domain.entity.Camera
import javax.inject.Inject

interface CameraLocalDataSource {

    suspend fun get(): List<Camera>

    suspend fun set(cameras: List<Camera>)
}

class CameraLocalDataSourceImpl @Inject constructor(
    private val converter: CameraLocalConverter,
    private val dao: CameraDao
) : CameraLocalDataSource {

    override suspend fun get(): List<Camera> =
        dao.get().map(converter::revert)

    override suspend fun set(cameras: List<Camera>) {
        cameras.map(converter::convert).also { dao.set(it) }
    }
}