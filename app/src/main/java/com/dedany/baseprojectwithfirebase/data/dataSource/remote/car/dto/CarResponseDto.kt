package com.dedany.baseprojectwithfirebase.data.dataSource.remote.car.dto

import com.google.gson.annotations.SerializedName

data class CarResponseDto(
    @SerializedName("items") val cars: List<CarDto>,
    @SerializedName("current_page") val currentPage: Int?,
    @SerializedName("total_pages")  val totalPages: Int?,
    @SerializedName("current_date") val currentDate: String
)