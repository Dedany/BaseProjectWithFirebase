package com.dedany.baseprojectwithfirebase.domain.useCases.auth

import com.dedany.baseprojectwithfirebase.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(private val repository: AuthRepository): AuthUseCase{

   override suspend fun login (email: String, password: String): Boolean {
        return repository.login(email, password)
    }
}