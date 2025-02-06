package com.dedany.baseprojectwithfirebase.data.dataSource.local.car.dbo

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cars")
data class CarDbo(
    @PrimaryKey val id: Int,
    val color: String,
    val brand: String,
    val year: Int,
    val model: String
)
