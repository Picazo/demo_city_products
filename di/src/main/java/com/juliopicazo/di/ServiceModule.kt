package com.juliopicazo.di

import com.juliopicazo.data.service.ProductServiceImpl
import com.juliopicazo.data.service.api.ProductsAPI
import com.juliopicazo.domain.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun provideProductService(productsApi: ProductsAPI): ProductRepository = ProductServiceImpl(productsApi)

}