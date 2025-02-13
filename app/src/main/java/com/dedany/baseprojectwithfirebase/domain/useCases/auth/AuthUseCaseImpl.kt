package com.dedany.baseprojectwithfirebase.domain.useCases.auth

import com.dedany.baseprojectwithfirebase.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(private val repository: AuthRepository) : AuthUseCase {

    override suspend fun login(email: String, password: String): Boolean {
        return repository.login(email, password)
    }

    override fun isEmailFormatValid(email: String): Boolean {
        if (email.isNullOrEmpty()) {
            return false
        }
        if (email.matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))) {
            return true
        }
        return false
    }


    override fun isPasswordFormatValid(password: String): Boolean {
        if (password.isNullOrEmpty()) {
            return false
        }
        if (password.matches("^(?=.{8,})(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[/:()&@?!'\\[\\]\"\${}#%^*+=_¿¡|<>`£¥€~-]).*\$".toRegex())) {
            return true
        }
        return false
    }

    override fun isLoginFormValid(email: String, password: String): Boolean {
        return isEmailFormatValid(email) && isPasswordFormatValid(password)
    }


    override fun isNameValid(name: String): Boolean {
        return name.isNotBlank() && name.length <= 50
    }

    override fun isAgeValid(age: Int): Boolean {
        return age in 1..150
    }

    override fun isPasswordMatching(password: String, repeatPassword: String): Boolean {
        val passwordMatches = password == repeatPassword
        return passwordMatches
    }

    override suspend fun register(
        name: String,
        age: Int,
        email: String,
        country: String,
        password: String
    ): Boolean {
        return repository.register(name, age, email, country, password)
    }


    override fun isRegisterFormValid(
        name: String,
        age: Int,
        email: String,
        country: String,
        password: String,
        repeatPassword: String
    ): Boolean {
        return true

//        isNameValid(name) && isAgeValid(age.toInt()) && isEmailFormatValid(email) && isPasswordFormatValid(
//            password
//        ) && isPasswordMatching(password, repeatPassword)
    }


}