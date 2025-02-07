package com.dedany.baseprojectwithfirebase.data.dataSource.mock.car

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.CarRemoteDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarResponseDto
import javax.inject.Inject

class CarMockDataSourceImpl @Inject constructor(): CarRemoteDataSource {

    override suspend fun getAllCars(): CarResponseDto {
        return CarResponseDto(listOf(), 1,10,"")
    }

    override suspend fun getCarById(id: Int): CarDto {
        return CarDto(1,"Azul", "Mercedes Ven", 2024, "MeVoyVoyage")
    }

    override suspend fun deleteCarByIdAndGetIsSuccess(id: Int): CarDto {
        return CarDto(1,"Azul", "Mercedes Ven", 2024, "MeVoyVoyage")
    }

    override suspend fun updateCarInformationById(id: Int): CarDto {
        return CarDto(1,"Azul", "Mercedes Ven", 2024, "MeVoyVoyage")
    }

    override suspend fun getCarsByBrand(brand: String): List<CarDto> {
        return listOf()
    }
}