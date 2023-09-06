package com.example.cameralock.di

import com.example.cameralock.data.datasource.DoorsLocalDataSource
import com.example.cameralock.data.datasource.DoorsLocalDataSourceImpl
import com.example.cameralock.data.datasource.DoorsRemoteDataSourceImpl
import com.example.cameralock.data.datasource.DoorsRemoteDatasource
import com.example.cameralock.data.repository.DoorRepositoryImpl
import com.example.cameralock.domain.repository.DoorRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DoorModule {

    @Singleton
    @Binds
    fun bindDoorRepository(impl: DoorRepositoryImpl): DoorRepository

    @Singleton
    @Binds
    fun bindDoorsLocalDataSource(impl: DoorsLocalDataSourceImpl): DoorsLocalDataSource

    @Singleton
    @Binds
    fun bindDoorsRemoteDataSource(impl: DoorsRemoteDataSourceImpl): DoorsRemoteDatasource

}