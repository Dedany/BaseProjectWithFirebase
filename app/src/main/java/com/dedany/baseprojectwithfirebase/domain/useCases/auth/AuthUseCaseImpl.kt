package com.dedany.baseprojectwithfirebase.domain.useCases.auth

import com.dedany.baseprojectwithfirebase.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(private val repository: AuthRepository) : AuthUseCase {

    override suspend fun login(email: String, password: String): Boolean {
        return repository.login(email, password)
    }

    override  fun isEmailFormatValid(email: String): Boolean {
        if (email.isNullOrEmpty()) {
            return false
        }
        if (email.matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))) {
            return true
        }
        return false
    }


    override  fun isPasswordFormatValid(password: String): Boolean {
        if (password.isNullOrEmpty()) {
            return false
        }
        if (password.matches("^(?=.{8,})(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[/:()&@?!'\\[\\]\"\${}#%^*+=_¿¡|<>`£¥€~-]).*\$".toRegex())){
            return true
    }
    return false
}

override  fun isLoginFormValid(email: String, password: String): Boolean {
    return isEmailFormatValid(email) && isPasswordFormatValid(password)
}
}