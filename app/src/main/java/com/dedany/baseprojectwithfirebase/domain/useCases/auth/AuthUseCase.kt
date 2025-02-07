package com.dedany.baseprojectwithfirebase.domain.useCases.auth

interface AuthUseCase {

suspend fun login(email: String, password: String) : Boolean
}