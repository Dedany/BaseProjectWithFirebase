package com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto

import java.time.LocalDate

data class UserDto(
    val id: String,
    val name: String,
    val lastname: String,
    val email: String,
    val age: Int,
    val isAdmin:Boolean,
    val registeredAt: LocalDate =LocalDate.now()

)
