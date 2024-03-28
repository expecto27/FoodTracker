package com.example.foodtracker.di

import com.example.foodtracker.domain.usecase.CalculateIMT
import com.example.foodtracker.domain.usecase.GetImtVerdict
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule{
    @Provides
    @ViewModelScoped
    fun provideCalculateIMT(): CalculateIMT {
        return CalculateIMT()
    }

    @Provides
    @ViewModelScoped
    fun provideGetImtVerdict(): GetImtVerdict{
        return GetImtVerdict()
    }
}
