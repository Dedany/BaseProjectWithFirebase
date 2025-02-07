package com.dedany.baseprojectwithfirebase.domain.useCases.car

import com.dedany.baseprojectwithfirebase.domain.entities.Car

interface CarUseCase {

    suspend fun getAllCars(): List<Car>

    suspend fun getCarById(id: Int): Car

    suspend fun deleteCarByIdAndGetIsSuccess(id: Int): Boolean

    suspend fun updateCarInformationById(id: Int): Boolean

    suspend fun getCarsByBrand(Brand: String): List<Car>
}