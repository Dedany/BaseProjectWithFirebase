package com.dedany.baseprojectwithfirebase.di

import android.content.Context
import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.dao.CarDao
import com.dedany.baseprojectwithfirebase.data.dataSource.local.room.Roomdb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
    @InstallIn(SingletonComponent::class)
    object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Context): Roomdb {
        return Roomdb.invoke(application)
    }

    @Provides
    @Singleton
    fun provideCarDao(database: Roomdb): CarDao {
        return database.carDao()
    }
}