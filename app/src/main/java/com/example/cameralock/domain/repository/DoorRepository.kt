package com.example.cameralock.domain.repository

import com.example.cameralock.domain.entity.Door

interface DoorRepository {

    suspend fun get(): List<Door>

    suspend fun update(door: Door)

    suspend fun forceRefresh(): List<Door>

}