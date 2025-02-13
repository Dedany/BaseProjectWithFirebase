package com.dedany.baseprojectwithfirebase.data.dataSource.remote.car

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarResponseDto

interface CarRemoteDataSource {

    suspend fun getAllCars(): CarResponseDto

    suspend fun getCarById(id: Int): CarDto

    suspend fun deleteCarByIdAndGetIsSuccess(id: Int): CarDto

    suspend fun updateCarInformationById(id: Int): CarDto

    suspend fun getCarsByBrand(Brand: String): List<CarDto>
}