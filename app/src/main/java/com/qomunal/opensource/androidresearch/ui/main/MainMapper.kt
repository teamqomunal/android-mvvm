package com.qomunal.opensource.androidresearch.ui.main

import com.qomunal.opensource.androidresearch.common.ext.toJson
import com.qomunal.opensource.androidresearch.model.ArticleModel
import com.qomunal.opensource.androidresearch.model.MainModel
import com.qomunal.opensource.androidresearch.model.MealModel

/**
 * Created by faisalamircs on 21/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


object MainMapper {

    fun articleMapper(input: ArticleModel): MainModel {
        return MainModel(
            title = input.title,
            description = input.description,
            image = input.urlToImage,
            data = input.toJson(),
        )
    }

    fun mealMapper(input: MealModel): MainModel {
        return MainModel(
            title = input.strMeal,
            description = input.strCategory,
            image = input.strMealThumb,
            data = input.toJson(),
        )
    }

}