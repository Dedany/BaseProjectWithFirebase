package com.dedany.baseprojectwithfirebase.domain.repositories

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarResponseDto
import com.dedany.baseprojectwithfirebase.domain.entities.Car

interface CarRepository {

    suspend fun getAllCars(): List<Car>

    suspend fun getCarById(id: Int): Car

    suspend fun deleteCarByIdAndGetIsSuccess(id: Int): Boolean

    suspend fun updateCarInformationById(id: Int): Boolean

    suspend fun getCarsByBrand(Brand: String): List<Car>
}