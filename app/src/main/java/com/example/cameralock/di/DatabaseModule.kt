package com.example.cameralock.di

import com.example.cameralock.data.local.dao.CameraDao
import com.example.cameralock.data.local.dao.DoorDao
import com.example.cameralock.data.local.model.CameraLocalModel
import com.example.cameralock.data.local.model.DoorLocalModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(): Realm {
        val config = RealmConfiguration.Builder(
            schema = setOf(
                CameraLocalModel::class,
                DoorLocalModel::class
            )
        )
            .compactOnLaunch()
            .build()
        return Realm.open(config)
    }

    @Singleton
    @Provides
    fun provideCameraDao(realm: Realm): CameraDao = CameraDao(realm)

    @Singleton
    @Provides
    fun provideDoorDao(realm: Realm): DoorDao = DoorDao(realm)

}