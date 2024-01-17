package com.qomunal.opensource.androidresearch.di

import com.qomunal.opensource.androidresearch.domain.meal.usecase.MealUseCase
import com.qomunal.opensource.androidresearch.domain.meal.usecase.MealUseCaseImpl
import com.qomunal.opensource.androidresearch.domain.news.usecase.NewsUseCase
import com.qomunal.opensource.androidresearch.domain.news.usecase.NewsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by faisalamircs on 17/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun provideNewsUseCase(useCase: NewsUseCaseImpl): NewsUseCase

    @Binds
    @ViewModelScoped
    abstract fun provideMealUseCase(useCase: MealUseCaseImpl): MealUseCase

}