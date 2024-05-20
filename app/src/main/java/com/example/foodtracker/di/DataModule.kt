package com.example.foodtracker.di

import android.content.Context
import com.example.foodtracker.data.database.AppDataBase
import com.example.foodtracker.data.database.dao.DrinkStatDao
import com.example.foodtracker.data.database.dao.EatDayDao
import com.example.foodtracker.data.database.dao.ProductDao
import com.example.foodtracker.data.repository.DrinkRepositoryImpl
import com.example.foodtracker.data.repository.EatingRepositoryImpl
import com.example.foodtracker.data.repository.ProductApiRepositoryImpl
import com.example.foodtracker.data.repository.ProductRepositoryImpl
import com.example.foodtracker.data.repository.UserDataRepositoryImpl
import com.example.foodtracker.domain.repository.DrinkRepository
import com.example.foodtracker.domain.repository.EatingRepository
import com.example.foodtracker.domain.repository.ProductApiRepository
import com.example.foodtracker.domain.repository.ProductRepository
import com.example.foodtracker.domain.repository.UserDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDataBase {
        return AppDataBase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideProductDao(dataBase: AppDataBase): ProductDao {
        return dataBase.ProductDao()
    }

    @Provides
    @Singleton
    fun provideProductRepository(productDao: ProductDao): ProductRepository {
        return ProductRepositoryImpl(productDao)
    }


    @Provides
    @Singleton
    fun provideEatDayDao(dataBase: AppDataBase): EatDayDao {
        return dataBase.EatDayDao()
    }

    @Provides
    @Singleton
    fun provideDrinkStatDao(dataBase: AppDataBase): DrinkStatDao {
        return dataBase.DrinkStatDao()
    }
    @Provides
    @Singleton
    fun provideEatingRepository(eatDayDao: EatDayDao): EatingRepository {
        return EatingRepositoryImpl(eatDayDao)
    }

    @Provides
    @Singleton
    fun provideUserDataRepository(@ApplicationContext context: Context): UserDataRepository {
        return UserDataRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideDrinkRepository(drinkStatDao: DrinkStatDao): DrinkRepository {
        return DrinkRepositoryImpl(drinkStatDao)
    }



    @Provides
    @Singleton
    fun provideProductApiRepository(): ProductApiRepository {
        return ProductApiRepositoryImpl()
    }
}