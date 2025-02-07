package com.dedany.baseprojectwithfirebase.domain.repositories

interface AuthRepository {

    suspend fun login()

    suspend fun logout()

    suspend fun register()

}