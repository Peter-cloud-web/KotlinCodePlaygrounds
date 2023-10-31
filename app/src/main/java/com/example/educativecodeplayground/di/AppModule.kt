package com.example.educativecodeplayground.di

import com.example.educativecodeplayground.api.ApiInterface
import com.example.educativecodeplayground.repository.CoinRepository
import com.example.educativecodeplayground.repository.CoinRepositoryImpl
import com.example.educativecodeplayground.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit():ApiInterface =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun provideRepository(apiInterface: ApiInterface):CoinRepository{
        return CoinRepositoryImpl(apiInterface)
    }
}