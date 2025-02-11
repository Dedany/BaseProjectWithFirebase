package com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto

import java.time.LocalDate

data class UserDto(
    val uuid: String?,
    val name: String,
    val email: String,
    val password: String,
    val age: Int,
    val country: String,
    val isAdmin:Boolean,
    val registeredAt: LocalDate =LocalDate.now()

)
