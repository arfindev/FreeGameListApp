package com.example.freegamelistapp.di

import com.example.freegamelistapp.common.Constants.BASE_URL
import com.example.freegamelistapp.data.remote.FreeGamesApi
import com.example.freegamelistapp.data.repository.FreeGamesRepositoryImpl
import com.example.freegamelistapp.domain.repository.FreeGamesRepository
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
    fun providesFreeGamesApi(): FreeGamesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(FreeGamesApi::class.java)
    }

    @Provides
    @Singleton
    fun providesFreeGamesRepository(api: FreeGamesApi): FreeGamesRepository {
        return FreeGamesRepositoryImpl(api)
    }
}