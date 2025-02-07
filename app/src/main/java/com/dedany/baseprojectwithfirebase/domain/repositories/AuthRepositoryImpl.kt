package com.dedany.baseprojectwithfirebase.domain.repositories

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.AuthRemoteDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.LoginDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.UserDto
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {

    override suspend fun login(email: String, password: String): Boolean {
        val loginReq= LoginDto(email, password,null)
        val dto= authRemoteDataSource.login(loginReq)
        if(!dto.token.isNullOrEmpty()) {
            return true
        }
        return false
    }

    override suspend fun logout(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun register(userDto: UserDto): UserDto {
        TODO("Not yet implemented")
    }


}