package com.dedany.baseprojectwithfirebase.domain.useCases.auth

import com.dedany.baseprojectwithfirebase.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(private val authRepository: AuthRepository): AuthUseCase{
}