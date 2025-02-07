package com.dedany.baseprojectwithfirebase.data.dataSource.remote.car

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.api.CarApi
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarResponseDto
import javax.inject.Inject

class CarRemoteDataSourceImpl @Inject constructor(private val carApi: CarApi):CarRemoteDataSource {
    override suspend fun getAllCars(): CarResponseDto {
       return carApi.getAllCars()
    }

    override suspend fun getCarById(id: Int): CarDto {
        return carApi.getCarById(id)
    }

    override suspend fun deleteCarByIdAndGetIsSuccess(id: Int): CarDto {
        return carApi.deleteCarByIdAndGetIsSuccess(id)
    }

    override suspend fun updateCarInformationById(id: Int): CarDto {
        return carApi.updateCarInformationById(id)
    }

    override suspend fun getCarsByBrand(brand: String): List<CarDto> {
        return carApi.getCarsByBrand(brand)
    }
}