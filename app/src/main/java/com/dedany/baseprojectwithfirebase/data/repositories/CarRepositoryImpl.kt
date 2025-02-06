package com.dedany.baseprojectwithfirebase.data.repositories

import com.dedany.baseprojectwithfirebase.data.dataSource.local.car.CarLocalDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.CarRemoteDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarResponseDto
import com.dedany.baseprojectwithfirebase.di.DataSourceModule
import com.dedany.baseprojectwithfirebase.di.Mock
import com.dedany.baseprojectwithfirebase.domain.repositories.CarRepository
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    @Mock private val carMockDataSource: CarRemoteDataSource,
    private val carRemoteDataSource: CarRemoteDataSource,
    private val carLocalDataSource: CarLocalDataSource
) : CarRepository {
    override suspend fun getAllCars(): CarResponseDto {
        return carMockDataSource.getAllCars()
    }

    override suspend fun getCarById(id: Int): CarDto {
        return carMockDataSource.getCarById(id)
    }

    override suspend fun deleteCarByIdAndGetIsSuccess(id: Int): CarDto {
        return carMockDataSource.deleteCarByIdAndGetIsSuccess(id)
    }

    override suspend fun updateCarInformationById(id: Int): CarDto {
        return carMockDataSource.updateCarInformationById(id)
    }

    override suspend fun getCarsByBrand(brand: String): List<CarDto> {
        return carMockDataSource.getCarsByBrand(brand)
    }
}