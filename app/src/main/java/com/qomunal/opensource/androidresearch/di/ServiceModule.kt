package com.qomunal.opensource.androidresearch.di

import com.qomunal.opensource.androidresearch.domain.news.remote.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter

/**
 * Created by faisalamircs on 14/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun provideNewsApiService(
        httpClient: OkHttpClient.Builder,
        converterFactory: Converter.Factory
    ): NewsApiService {
        return NewsApiService.Creator(httpClient, converterFactory).createApi()
    }

//    @Provides
//    fun provideMealApiService(
//        httpClient: OkHttpClient.Builder,
//        converterFactory: Converter.Factory
//    ): MealApiService {
//        return MealApiService.Creator().createApi(httpClient, converterFactory)
//    }

}