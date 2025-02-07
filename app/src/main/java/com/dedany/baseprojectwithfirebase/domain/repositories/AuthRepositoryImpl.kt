package com.dedany.baseprojectwithfirebase.domain.repositories

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.AuthRemoteDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.LoginDto
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {

    override suspend fun login(email: String, password: String) {
        val loginReq= LoginDto(email, password)
        val dto= authRemoteDataSource.login(loginReq)
        if(!dto.token.isNullOrEmpty()) {
            return true
        }
        return false
    }



    override suspend fun logout() {
        TODO("Not yet implemented")
    }

    override suspend fun register() {
        TODO("Not yet implemented")
    }


}