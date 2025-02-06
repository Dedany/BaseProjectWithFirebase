package com.dedany.baseprojectwithfirebase.domain.repositories

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarResponseDto
import com.dedany.baseprojectwithfirebase.domain.entities.Car

interface CarRepository {

    suspend fun getAllCars(): CarResponseDto

    suspend fun getCarById(id: Int): CarDto

    suspend fun deleteCarByIdAndGetIsSuccess(id: Int): CarDto

    suspend fun updateCarInformationById(id: Int): CarDto

    suspend fun getCarsByBrand(Brand: String): List<CarDto>
}