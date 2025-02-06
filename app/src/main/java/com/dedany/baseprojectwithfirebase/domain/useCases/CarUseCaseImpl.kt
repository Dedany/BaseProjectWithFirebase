package com.dedany.baseprojectwithfirebase.domain.useCases

import com.dedany.baseprojectwithfirebase.domain.entities.Car
import com.dedany.baseprojectwithfirebase.domain.repositories.CarRepository
import javax.inject.Inject

class CarUseCaseImpl @Inject constructor(private val repository: CarRepository) : CarUseCase {
    override suspend fun getAllCars(): List<Car> {
        return repository.getAllCars()
    }

    override suspend fun getCarById(id: Int): Car {
        return repository.getCarById(id)
    }

    override suspend fun deleteCarByIdAndGetIsSuccess(id: Int): Boolean {
        return repository.deleteCarByIdAndGetIsSuccess(id)
    }

    override suspend fun updateCarInformationById(id: Int): Boolean {
        return repository.updateCarInformationById(id)
    }

    override suspend fun getCarsByBrand(Brand: String): List<Car> {
        return repository.getCarsByBrand(Brand)
    }
}