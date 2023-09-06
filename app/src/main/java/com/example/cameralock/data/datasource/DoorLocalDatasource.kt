package com.example.cameralock.data.datasource

import com.example.cameralock.data.converter.DoorLocalConverter
import com.example.cameralock.data.local.dao.DoorDao
import com.example.cameralock.domain.entity.Door
import javax.inject.Inject

interface DoorsLocalDataSource {

    suspend fun get(): List<Door>

    suspend fun set(doors: List<Door>)

    suspend fun update(door: Door)

}

class DoorsLocalDataSourceImpl @Inject constructor(
    private val dao: DoorDao,
    private val converter: DoorLocalConverter
) : DoorsLocalDataSource {

    override suspend fun get(): List<Door> =
        dao.get().map(converter::revert)

    override suspend fun set(doors: List<Door>) {
        doors.map(converter::convert).also { dao.set(it) }
    }

    override suspend fun update(door: Door) {
        dao.update(converter.convert(door))
    }
}