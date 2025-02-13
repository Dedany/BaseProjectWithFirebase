package com.dedany.baseprojectwithfirebase.data.dataSource.local.car

import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.dbo.CarDbo

interface CarLocalDataSource {
    suspend fun getAllCars(): List<CarDbo>
}