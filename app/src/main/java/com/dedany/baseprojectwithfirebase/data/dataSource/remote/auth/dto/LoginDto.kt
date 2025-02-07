package com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto

data class LoginDto(
    val user: String,
    val password: String,
    val token: String?
)
