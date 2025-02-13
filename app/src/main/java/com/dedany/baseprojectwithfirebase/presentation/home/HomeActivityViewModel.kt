package com.dedany.baseprojectwithfirebase.presentation.home

import androidx.lifecycle.ViewModel
import com.dedany.baseprojectwithfirebase.domain.useCases.car.CarUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeActivityViewModel @Inject constructor(private val carUseCase: CarUseCase): ViewModel() {
}