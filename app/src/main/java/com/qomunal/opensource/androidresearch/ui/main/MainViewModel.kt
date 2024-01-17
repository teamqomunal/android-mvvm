package com.qomunal.opensource.androidresearch.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.qomunal.opensource.androidresearch.common.base.BaseViewModel
import com.qomunal.opensource.androidresearch.domain.Resource
import com.qomunal.opensource.androidresearch.domain.meal.usecase.MealUseCase
import com.qomunal.opensource.androidresearch.domain.news.usecase.NewsUseCase
import com.qomunal.opensource.androidresearch.model.ArticleModel
import com.qomunal.opensource.androidresearch.model.MealModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by faisalamircs on 13/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase,
    private val mealUseCase: MealUseCase
) : BaseViewModel() {

    private var _newsArticlesState = MutableLiveData<Resource<List<ArticleModel>>>()
    var newsArticlesState: LiveData<Resource<List<ArticleModel>>> = _newsArticlesState

    private var _mealState = MutableLiveData<Resource<List<MealModel>>>()
    var mealState: LiveData<Resource<List<MealModel>>> = _mealState

    fun getNewsArticle() {
        viewModelScope.launch {
            newsUseCase.getTopHeadline("")
                .onEach {
                    _newsArticlesState.postValue(it)
                }.launchIn(viewModelScope)
        }
    }

    fun getMeals() {
        viewModelScope.launch {
            mealUseCase.listAllMeal("C")
                .onEach {
                    _mealState.postValue(it)
                }.launchIn(viewModelScope)
        }
    }

}