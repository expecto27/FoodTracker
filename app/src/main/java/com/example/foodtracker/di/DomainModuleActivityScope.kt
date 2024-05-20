package com.example.foodtracker.di

import com.example.foodtracker.domain.repository.ProductApiRepository
import com.example.foodtracker.domain.usecase.CheckServerConnection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class DomainModuleActivityScope {

    @Provides
    @ActivityScoped
    fun provideCheckServerConnection(productApiRepository: ProductApiRepository): CheckServerConnection {
        return CheckServerConnection(productApiRepository)
    }
}