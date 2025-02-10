package com.dedany.baseprojectwithfirebase.domain.useCases.auth

interface AuthUseCase {

     suspend fun login(email: String, password: String): Boolean
     fun isEmailFormatValid(email: String): Boolean
     fun isPasswordFormatValid(password: String): Boolean
     fun isLoginFormValid(email: String, password: String): Boolean
}