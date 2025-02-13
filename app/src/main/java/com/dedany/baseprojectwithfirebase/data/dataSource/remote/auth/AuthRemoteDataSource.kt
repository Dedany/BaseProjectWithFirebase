package com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.LoginDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.UserDto

interface AuthRemoteDataSource {

    suspend fun login(loginDto: LoginDto): LoginDto
    fun logout(): Boolean
    suspend fun register(userDto: UserDto): Pair<Boolean, String>

}