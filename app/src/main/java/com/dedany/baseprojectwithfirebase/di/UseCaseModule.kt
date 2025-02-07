package com.dedany.baseprojectwithfirebase.di

import com.dedany.baseprojectwithfirebase.domain.repositories.AuthRepository
import com.dedany.baseprojectwithfirebase.domain.repositories.CarRepository
import com.dedany.baseprojectwithfirebase.domain.useCases.auth.AuthUseCase
import com.dedany.baseprojectwithfirebase.domain.useCases.auth.AuthUseCaseImpl
import com.dedany.baseprojectwithfirebase.domain.useCases.car.CarUseCase
import com.dedany.baseprojectwithfirebase.domain.useCases.car.CarUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {


    @Provides
    @Singleton
    fun provideCarUseCase(repository: CarRepository): CarUseCase {
        return CarUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideAuthUseCase(repository: AuthRepository): AuthUseCase {
        return AuthUseCaseImpl(repository)
    }
}