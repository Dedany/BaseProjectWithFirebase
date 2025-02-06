package com.dedany.baseprojectwithfirebase.di

import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.CarLocalDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.CarLocalDataSourceImpl
import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.dao.CarDao
import com.dedany.baseprojectwithfirebase.data.dataSource.mock.car.CarMockDataSourceImpl
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.CarRemoteDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.CarRemoteDataSourceImpl
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.api.CarApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {


    @Mock
    @Provides
    @Singleton
    fun provideCarMockDataSource(): CarRemoteDataSource {
        return CarMockDataSourceImpl()
    }



        @Provides
        @Singleton
        fun provideCarRemoteDataSource(carApi: CarApi): CarRemoteDataSource {
            return CarRemoteDataSourceImpl(carApi)
        }

        @Provides
        @Singleton
        fun provideCarLocalDataSource(carDao: CarDao): CarLocalDataSource {
            return CarLocalDataSourceImpl(carDao)
        }
    }

    @Qualifier
    @Retention
        (AnnotationRetention.BINARY)
    annotation class Mock
