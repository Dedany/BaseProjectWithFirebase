package com.dedany.baseprojectwithfirebase.presentation.main

import androidx.lifecycle.ViewModel
import com.dedany.baseprojectwithfirebase.domain.useCases.CarUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(private val carUseCase: CarUseCase): ViewModel() {
}