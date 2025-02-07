package com.dedany.baseprojectwithfirebase.data.dataSource.local.car

import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.dao.CarDao
import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.dbo.CarDbo
import javax.inject.Inject

class CarLocalDataSourceImpl @Inject constructor(private val carDao: CarDao) : CarLocalDataSource {
    override suspend fun getAllCars(): List<CarDbo> {
        return carDao.getAllCars()
    }
}