package com.example.cameralock.data.repository

import com.example.cameralock.data.datasource.CameraLocalDataSource
import com.example.cameralock.data.datasource.CameraRemoteDataSource
import com.example.cameralock.domain.entity.Camera
import com.example.cameralock.domain.repository.CameraRepository
import javax.inject.Inject

class CameraRepositoryImpl @Inject constructor(
    private val localDataSource: CameraLocalDataSource,
    private val remoteDataSource: CameraRemoteDataSource
) : CameraRepository {

    override suspend fun get(): List<Camera> {
        return getLocal().ifEmpty {
            getRemote()
        }
    }

    override suspend fun forceRefresh(): List<Camera>  =
        getRemote()

    private suspend fun getLocal(): List<Camera> =
        localDataSource.get()

    private suspend fun getRemote(): List<Camera> =
        remoteDataSource.get().also {
            localDataSource.set(it)
        }
}