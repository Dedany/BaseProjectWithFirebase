package com.dedany.baseprojectwithfirebase.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dedany.baseprojectwithfirebase.domain.useCases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    private var _isLoginSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val isLoginSuccess: LiveData<Boolean> = _isLoginSuccess

    private var _canDoLogin: MutableLiveData<Boolean> = MutableLiveData(false)
    val canDoLogin:LiveData<Boolean> = _canDoLogin

    private var email: String = ""
    private var password: String = ""

    fun setEmail(text: String) {
        email = text
        _canDoLogin.value = authUseCase.isLoginFormValid(email, password)
    }

    fun setPassword(text: String) {
        password = text
        _canDoLogin.value = authUseCase.isLoginFormValid(email, password)
    }

    fun login() {
        val isEmailValid = authUseCase.isEmailFormatValid(email)
        val isPassWordValid = authUseCase.isPasswordFormatValid(password)

        if (isEmailValid && isPassWordValid) {
            viewModelScope.launch {
                _isLoginSuccess.value = authUseCase.login(email, password)
            }
        }
    }
}

