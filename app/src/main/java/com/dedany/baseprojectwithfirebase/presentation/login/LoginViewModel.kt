package com.dedany.baseprojectwithfirebase.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dedany.baseprojectwithfirebase.domain.useCases.auth.AuthUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    private var _isLoginSuccess: MutableLiveData<Boolean> = MutableLiveData()
     val isLoginSuccess: LiveData<Boolean> = _isLoginSuccess

    private var email: String = ""
    private var password: String = ""

    fun setEmail(text: String) {
        email = text
    }
    fun setPassword(text: String) {
        password = text
    }

    fun login() {
        viewModelScope.launch {
            _isLoginSuccess.value= authUseCase.login(email, password)
        }

    }
}