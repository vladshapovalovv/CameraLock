package com.example.cameralock.di

import com.example.cameralock.data.datasource.CameraLocalDataSource
import com.example.cameralock.data.datasource.CameraLocalDataSourceImpl
import com.example.cameralock.data.datasource.CameraRemoteDataSource
import com.example.cameralock.data.datasource.CameraRemoteDataSourceImpl
import com.example.cameralock.data.repository.CameraRepositoryImpl
import com.example.cameralock.domain.repository.CameraRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CameraModule {

    @Singleton
    @Binds
    fun bindCameraRepository(impl: CameraRepositoryImpl): CameraRepository

    @Singleton
    @Binds
    fun bindCameraLocalDataSource(impl: CameraLocalDataSourceImpl): CameraLocalDataSource

    @Singleton
    @Binds
    fun bindCameraRemoteDataSource(impl: CameraRemoteDataSourceImpl): CameraRemoteDataSource

}