package com.dedany.baseprojectwithfirebase.domain.repositories

import com.dedany.baseprojectwithfirebase.data.dataSource.remote.auth.AuthRemoteDataSource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {


}