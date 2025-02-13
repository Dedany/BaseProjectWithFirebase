package com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.api

import androidx.room.Query
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto.CarResponseDto
import retrofit2.http.GET

interface CarApi {

    @GET("api/v1/cars")
    suspend fun getAllCars(): CarResponseDto

    @GET("api/v1/cars?")
    suspend fun getCarById (id: Int): CarDto

    @GET("api/v1/cars")
    suspend fun deleteCarByIdAndGetIsSuccess(id: Int): CarDto

    @GET("api/v1/cars")
    suspend fun updateCarInformationById(id: Int): CarDto

    @GET("api/v1/cars")
    suspend fun getCarsByBrand(Brand: String): List<CarDto>
}