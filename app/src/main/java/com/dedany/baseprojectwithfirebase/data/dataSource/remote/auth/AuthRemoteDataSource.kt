package com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.LoginDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.UserDto

interface AuthRemoteDataSource {

    fun login(loginDto: LoginDto): LoginDto

    fun logout(): Boolean

    fun register(userDto: UserDto): UserDto

}