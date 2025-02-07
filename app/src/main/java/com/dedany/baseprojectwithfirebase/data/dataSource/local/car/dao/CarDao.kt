package com.dedany.baseprojectwithfirebase.data.dataSource.local.car.dao

import androidx.room.Dao
import androidx.room.Query
import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.dbo.CarDbo

@Dao
interface CarDao {

    @Query("SELECT * FROM cars")
    fun getAllCars(): List<CarDbo>

}