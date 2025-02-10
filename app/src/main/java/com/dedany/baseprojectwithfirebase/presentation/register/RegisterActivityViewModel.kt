package com.dedany.baseprojectwithfirebase.presentation.register

import androidx.lifecycle.ViewModel
import com.dedany.baseprojectwithfirebase.domain.useCases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterActivityViewModel @Inject constructor(private val authUseCase: AuthUseCase):ViewModel() {
}