package com.dedany.baseprojectwithfirebase.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dedany.baseprojectwithfirebase.domain.useCases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _name: MutableLiveData<String> = MutableLiveData()
    val name: LiveData<String> = _name

    private val _age: MutableLiveData<Int> = MutableLiveData()
    val age: LiveData<Int> = _age

    private val _email: MutableLiveData<String> = MutableLiveData()
    val email: LiveData<String> = _email

    private val _country: MutableLiveData<String> = MutableLiveData()
    val country: LiveData<String> = _country

    private val _password: MutableLiveData<String> = MutableLiveData()
    val password: LiveData<String> = _password

    private val _repeatPassword: MutableLiveData<String> = MutableLiveData()
    val repeatPassword: LiveData<String> = _repeatPassword

    //tratamos los errores
    private val _nameHasError: MutableLiveData<Boolean> = MutableLiveData()
    val nameHasError: LiveData<Boolean> = _nameHasError

    private val _ageHasError: MutableLiveData<Boolean> = MutableLiveData()
    val ageHasError: LiveData<Boolean> = _ageHasError

    private val _emailHasError: MutableLiveData<Boolean> = MutableLiveData()
    val emailHasError: LiveData<Boolean> = _emailHasError


    private val _countryHasError: MutableLiveData<Boolean> = MutableLiveData()
    val countryHasError: LiveData<Boolean> = _countryHasError

    private val _passwordHasError: MutableLiveData<Boolean> = MutableLiveData()
    val passwordHasError: LiveData<Boolean> = _passwordHasError

    private val _repeatPasswordHasError: MutableLiveData<Boolean> = MutableLiveData()
    val repeatPasswordHasError: LiveData<Boolean> = _repeatPasswordHasError

    private var _isRegisterSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val isRegisterSuccess: LiveData<Boolean> = _isRegisterSuccess

    private var _formHasError: MutableLiveData<Boolean> = MutableLiveData()
    val formHasError: LiveData<Boolean> = _formHasError

    fun setUsername(name: String) {
        _name.value = name
        _nameHasError.value = authUseCase.isNameValid(name)
    }

    fun setAge(age: String) {
        val pasedAge = age.toInt()
        _ageHasError.value = authUseCase.isAgeValid(age.toInt())
    }

    fun setEmail(email: String) {
        _email.value = email
        _emailHasError.value = authUseCase.isEmailFormatValid(email)
    }

    fun setCountry(country: String) {
        _country.value = country
    }

    fun setPassword(password: String) {
        _password.value = password
        _passwordHasError.value = authUseCase.isPasswordFormatValid(password)
    }

    fun setRepeatPassword(repeatPassword: String) {
        _repeatPassword.value = repeatPassword
        _password.value?.let { password ->
            _repeatPasswordHasError.value =
                authUseCase.isAPasswordMatching(password, repeatPassword)
        }
    }

        fun register() {
            viewModelScope.launch {
            val name = _name.value ?: ""
            val age = _age.value ?: 0
            val email = _email.value ?: ""
            val country = _country.value ?: ""
            val password = _password.value ?: ""
            val repeatPassword = _repeatPassword.value ?: ""
            if (authUseCase.isRegisterFormValid(name, age, email, country, password, repeatPassword)) {
                authUseCase.register(name, age, email, country, password)

            }
            }
        }
    }




