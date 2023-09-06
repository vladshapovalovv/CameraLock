package com.example.cameralock.domain.entity

data class Door(
    val name: String,
    val room: String?,
    val id: Int,
    val favorites: Boolean,
    val snapshot: String?
)
