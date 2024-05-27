package com.example.foodtracker.di

import com.example.foodtracker.data.database.dao.ProductDao
import com.example.foodtracker.data.repository.ProductApiRepositoryImpl
import com.example.foodtracker.data.repository.ProductRepositoryImpl
import com.example.foodtracker.domain.repository.DrinkRepository
import com.example.foodtracker.domain.repository.EatingRepository
import com.example.foodtracker.domain.repository.ProductRepository
import com.example.foodtracker.domain.repository.UserDataRepository
import com.example.foodtracker.domain.usecase.CalculateIMT
import com.example.foodtracker.domain.usecase.DeleteDrink
import com.example.foodtracker.domain.usecase.DeleteEating
import com.example.foodtracker.domain.usecase.GetDailyTarget
import com.example.foodtracker.domain.usecase.GetDrinkStat
import com.example.foodtracker.domain.usecase.GetEating
import com.example.foodtracker.domain.usecase.GetImtVerdict
import com.example.foodtracker.domain.usecase.GetUserData
import com.example.foodtracker.domain.usecase.SaveDrink
import com.example.foodtracker.domain.usecase.SaveEating
import com.example.foodtracker.domain.usecase.SaveMyProduct
import com.example.foodtracker.domain.usecase.SaveUserData
import com.example.foodtracker.domain.usecase.SearchMyProducts
import com.example.foodtracker.domain.usecase.SearchProducts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    @ViewModelScoped
    fun provideCalculateIMT(): CalculateIMT {
        return CalculateIMT()
    }

    @Provides
    @ViewModelScoped
    fun provideGetImtVerdict(): GetImtVerdict {
        return GetImtVerdict()
    }

    @Provides
    @ViewModelScoped
    fun provideSearchProduct(): SearchProducts {
        return SearchProducts(ProductApiRepositoryImpl())
    }

    @Provides
    @ViewModelScoped
    fun provideSaveMyProduct(productDao: ProductDao): SaveMyProduct {
        return SaveMyProduct(ProductRepositoryImpl(productDao))
    }

    @Provides
    @ViewModelScoped
    fun provideSaveEating(eatingRepository: EatingRepository): SaveEating {
        return SaveEating(eatingRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetEating(eatingRepository: EatingRepository): GetEating {
        return GetEating(eatingRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideDeleteEating(eatingRepository: EatingRepository): DeleteEating {
        return DeleteEating(eatingRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideSaveUserData(userDataRepository: UserDataRepository): SaveUserData {
        return SaveUserData(userDataRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetUserData(userDataRepository: UserDataRepository): GetUserData {
        return GetUserData(userDataRepository)
    }


    @Provides
    @ViewModelScoped
    fun provideGetDailyTarget(userDataRepository: UserDataRepository): GetDailyTarget {
        return GetDailyTarget(userDataRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetDrinkStat(drinkRepository: DrinkRepository): GetDrinkStat {
        return GetDrinkStat(drinkRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideSaveDrink(drinkRepository: DrinkRepository): SaveDrink {
        return SaveDrink(drinkRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideDeleteDrink(drinkRepository: DrinkRepository): DeleteDrink {
        return DeleteDrink(drinkRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideSearchMyProductRepository(productRepository: ProductRepository): SearchMyProducts {
        return SearchMyProducts(productRepository)
    }
}
