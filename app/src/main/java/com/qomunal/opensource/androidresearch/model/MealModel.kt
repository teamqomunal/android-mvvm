package com.qomunal.opensource.androidresearch.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

/**
 * Created by faisalamircs on 17/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Keep
@Parcelize
data class MealModel(
    var idMeal: String = "",
    var strMeal: String = "",
    var strDrinkAlternate: String = "",
    var strCategory: String = "",
    var strArea: String = "",
    var strInstructions: String = "",
    var strMealThumb: String = "",
    var strTags: String = "",
    var strYoutube: String = "",
    var strIngredient: List<String> = listOf(),
    var strMeasure: List<String> = listOf(),
    var strSource: String = "",
    var dateModified: String = ""
) : Parcelable
