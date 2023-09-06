package com.example.cameralock.data.repository

import com.example.cameralock.data.datasource.DoorsLocalDataSource
import com.example.cameralock.data.datasource.DoorsRemoteDatasource
import com.example.cameralock.domain.entity.Door
import com.example.cameralock.domain.repository.DoorRepository
import javax.inject.Inject

class DoorRepositoryImpl @Inject constructor(
    private val localDataSource: DoorsLocalDataSource,
    private val remoteDatasource: DoorsRemoteDatasource
) : DoorRepository {

    override suspend fun get(): List<Door> =
        getLocal().ifEmpty {
            getRemote()
        }

    override suspend fun update(door: Door) {
        localDataSource.update(door)
    }

    override suspend fun forceRefresh(): List<Door> = getRemote()

    private suspend fun getLocal(): List<Door> =
        localDataSource.get()

    private suspend fun getRemote(): List<Door> =
        remoteDatasource.get().also {
            localDataSource.set(it)
        }
}