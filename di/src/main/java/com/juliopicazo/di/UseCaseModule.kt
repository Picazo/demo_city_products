package com.juliopicazo.di

import com.juliopicazo.domain.GetProductUseCase
import com.juliopicazo.domain.GetProductUseCaseImpl
import com.juliopicazo.domain.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule
{
    @Provides
    fun providesGetProductsUseCase(
        repository: ProductRepository
    ): GetProductUseCase =
        GetProductUseCaseImpl(repository)
}