package com.example.cameralock.data.datasource

import com.example.cameralock.data.converter.DoorRemoteConverter
import com.example.cameralock.data.remote.api.DoorApi
import com.example.cameralock.domain.entity.Door
import javax.inject.Inject

interface DoorsRemoteDatasource {

    suspend fun get(): List<Door>

}

class DoorsRemoteDataSourceImpl @Inject constructor(
    private val api: DoorApi,
    private val converter: DoorRemoteConverter

) : DoorsRemoteDatasource {

    override suspend fun get(): List<Door> {
        return converter.convert(api.getDoors())
    }
}