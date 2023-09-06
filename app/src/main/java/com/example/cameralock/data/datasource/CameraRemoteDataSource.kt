package com.example.cameralock.data.datasource

import com.example.cameralock.data.converter.CameraRemoteConverter
import com.example.cameralock.data.remote.api.CameraApi
import com.example.cameralock.domain.entity.Camera
import javax.inject.Inject

interface CameraRemoteDataSource {

    suspend fun get(): List<Camera>

}

class CameraRemoteDataSourceImpl @Inject constructor(
    private val api: CameraApi,
    private val converter: CameraRemoteConverter,
) : CameraRemoteDataSource {

    override suspend fun get(): List<Camera> =
        converter.convert(api.getCameraData())

}

