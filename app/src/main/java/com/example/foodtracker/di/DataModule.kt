package com.example.foodtracker.di

import android.content.Context
import com.example.foodtracker.data.database.AppDataBase
import com.example.foodtracker.data.database.dao.ProductDao
import com.example.foodtracker.data.repository.ProductRepositoryImpl
import com.example.foodtracker.domain.repository.ProductRepository
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
    fun provideDataBase(@ApplicationContext context: Context): AppDataBase{
        return AppDataBase.getDatabase(context)
    }
    @Provides
    fun provideProductDao(dataBase: AppDataBase) : ProductDao{
        return dataBase.ProductDao()
    }
    @Provides
    @Singleton
    fun provideProductRepository(productDao: ProductDao) : ProductRepository{
        return ProductRepositoryImpl(productDao)
    }
}