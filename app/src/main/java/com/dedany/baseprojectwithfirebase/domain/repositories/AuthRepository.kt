package com.dedany.baseprojectwithfirebase.domain.repositories

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.dto.UserDto

interface AuthRepository {

    suspend fun login (email: String, password: String): Boolean

    suspend fun logout(): Boolean

    suspend fun register(name: String, age: Int, email: String, country: String, password: String) : Boolean
}
