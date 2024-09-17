package com.vu.androidbasicapp.home

import com.vu.androidbasicapp.home.network.RestfulApiDevRetrofitClient
import com.vu.androidbasicapp.home.network.RestfulApiDevService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeDiModule {

    @Provides
    @Singleton
    fun provideRestfulApiDevService(
    ): RestfulApiDevService {
        return RestfulApiDevRetrofitClient().apiService
    }
}


