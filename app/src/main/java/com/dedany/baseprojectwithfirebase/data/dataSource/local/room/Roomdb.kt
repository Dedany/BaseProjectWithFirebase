package com.dedany.baseprojectwithfirebase.data.dataSource.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.dbo.CarDbo
import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.dao.CarDao


@Database(entities = [CarDbo::class], version = 1)
abstract class Roomdb : RoomDatabase() {

    abstract fun carDao(): CarDao

    companion object {
        private val DATABASE_NAME = "cars_db"

        @Volatile
        var instance: Roomdb? = null
        val something: Any = Any()


    operator fun invoke(context: Context) = instance ?: synchronized(something) {
        createRoomDataBase(context).also { roomdb -> instance = roomdb}
        }

    private fun createRoomDataBase(context: Context): Roomdb {
        return Room.databaseBuilder(context, Roomdb::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}
}