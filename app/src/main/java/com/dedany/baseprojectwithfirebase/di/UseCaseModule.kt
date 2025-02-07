package com.dedany.baseprojectwithfirebase.di

import com.dedany.baseprojectwithfirebase.domain.repositories.CarRepository
import com.dedany.baseprojectwithfirebase.domain.useCases.CarUseCase
import com.dedany.baseprojectwithfirebase.domain.useCases.CarUseCaseImpl
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
}