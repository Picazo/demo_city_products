package com.juliopicazo.democity.di

import com.juliopicazo.di.ApiModule
import com.juliopicazo.di.ServiceModule
import com.juliopicazo.di.UseCaseModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module(
    includes = [
        ApiModule::class,
        UseCaseModule::class,
        ServiceModule::class
    ]
)

@InstallIn(SingletonComponent::class)
class AppModule