package com.dedany.baseprojectwithfirebase.domain.repositories

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.AuthRemoteDataSource
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.LoginDto
import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.UserDto
import java.time.LocalDate
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authRemoteDataSource: AuthRemoteDataSource) :
    AuthRepository {

    override suspend fun login(email: String, password: String): Boolean {
        val loginReq = LoginDto(email, password, null)
        val dto = authRemoteDataSource.login(loginReq)
        if (!dto.token.isNullOrEmpty()) {
            return true
        }
        return false
    }

    override suspend fun logout(): Boolean {
        return authRemoteDataSource.logout()
    }

    override suspend fun register(
        name: String,
        age: Int,
        email: String,
        country: String,
        password: String,
    ): Boolean {
        val dto = UserDto(
            uuid = null,
            name = name,
            email = email,
            age = age,
            country = country,
            password = password,
            isAdmin = false,
            registeredAt = LocalDate.now()
        )

        val response = authRemoteDataSource.register(dto)

        return !dto.uuid.isNullOrEmpty()
    }
}
