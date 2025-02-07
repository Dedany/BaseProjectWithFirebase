package com.dedany.baseprojectwithfirebase.data.repositories

import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.CarLocalDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.CarRemoteDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarResponseDto
import com.dedany.baseprojectwithfirebase.di.DataSourceModule
import com.dedany.baseprojectwithfirebase.di.Mock
import com.dedany.baseprojectwithfirebase.domain.entities.Car
import com.dedany.baseprojectwithfirebase.domain.repositories.CarRepository
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    @Mock private val carMockDataSource: CarRemoteDataSource,
    private val carRemoteDataSource: CarRemoteDataSource,
    private val carLocalDataSource: CarLocalDataSource
) : CarRepository {
    override suspend fun getAllCars(): List<Car> {
        return carMockDataSource.getAllCars().cars.map { it.toDomain() }
    }

    override suspend fun getCarById(id: Int): Car {
        return carMockDataSource.getCarById(id).toDomain()
    }


        override suspend fun deleteCarByIdAndGetIsSuccess(id: Int): Boolean {
            try {
                val car = carMockDataSource.deleteCarByIdAndGetIsSuccess(id).toDomain()
                return car.id > 0
            } catch (e: Exception) {
                return false
            }
        }

    override suspend fun updateCarInformationById(id: Int): Boolean {
        try {
            val car = carMockDataSource.updateCarInformationById(id).toDomain()
            return car.id > 0
        } catch (e: Exception) {
            return false
        }
    }

    override suspend fun getCarsByBrand(brand: String): List<Car> {
        return carMockDataSource.getCarsByBrand(brand).map{it.toDomain()}
    }

    private fun CarDto.toDomain():Car{
        return Car(id, color, brand, year, model)

    }
}