package com.dedany.baseprojectwithfirebase.domain.useCases.auth

interface AuthUseCase {

     suspend fun login(email: String, password: String): Boolean
     fun isEmailFormatValid(email: String): Boolean
     fun isPasswordFormatValid(password: String): Boolean
     fun isLoginFormValid(email: String, password: String): Boolean
     fun isNameValid(name: String): Boolean
     fun isAgeValid(age: Int): Boolean
     fun isRegisterFormValid(name: String, age: Int, email: String, country: String, password: String, repeatPassword: String): Boolean
     fun isPasswordMatching(password: String, repeatPassword: String): Boolean
    suspend fun register(name: String, age: Int, email: String, country: String, password: String): Boolean
}