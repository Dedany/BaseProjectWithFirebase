package com.dedany.baseprojectwithfirebase.di

import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.CarLocalDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.AuthRemoteDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.CarRemoteDataSource
import com.dedany.baseprojectwithfirebase.data.repositories.CarRepositoryImpl
import com.dedany.baseprojectwithfirebase.domain.repositories.AuthRepository
import com.dedany.baseprojectwithfirebase.domain.repositories.AuthRepositoryImpl
import com.dedany.baseprojectwithfirebase.domain.repositories.CarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCarRepository(
        @Mock carMockDataSource: CarRemoteDataSource,
        carRemoteDataSource: CarRemoteDataSource,
        carLocalDataSource: CarLocalDataSource
    ): CarRepository {
        return CarRepositoryImpl(carMockDataSource,carRemoteDataSource,carLocalDataSource)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
    ): AuthRepository {
        return AuthRepositoryImpl(authRemoteDataSource)
    }
}