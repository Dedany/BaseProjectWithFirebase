package com.dedany.baseprojectwithfirebase.domain.useCases

import com.dedany.baseprojectwithfirebase.domain.entities.Car
import javax.inject.Inject

class CarUseCaseImpl @Inject constructor() : CarUseCase {
    override suspend fun getAllCars(): List<Car> {
        TODO("Not yet implemented")
    }

    override suspend fun getCarById(id: Int): Car {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCarByIdAndGetIsSuccess(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateCarInformationById(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getCarsByBrand(Brand: String): List<Car> {
        TODO("Not yet implemented")
    }
}