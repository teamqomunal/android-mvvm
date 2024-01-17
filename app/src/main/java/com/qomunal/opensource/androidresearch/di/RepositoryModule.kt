package com.qomunal.opensource.androidresearch.di

import com.qomunal.opensource.androidresearch.domain.meal.repository.MealRepository
import com.qomunal.opensource.androidresearch.domain.meal.repository.MealRepositoryImpl
import com.qomunal.opensource.androidresearch.domain.news.repository.NewsRepository
import com.qomunal.opensource.androidresearch.domain.news.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by faisalamircs on 17/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Module(includes = [ServiceModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideNewsRepository(repository: NewsRepositoryImpl): NewsRepository

    @Binds
    abstract fun provideMealRepository(repository: MealRepositoryImpl): MealRepository


}