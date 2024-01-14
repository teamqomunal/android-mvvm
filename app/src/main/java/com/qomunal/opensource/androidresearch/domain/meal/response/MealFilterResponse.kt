package com.qomunal.opensource.androidresearch.domain.meal.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * TheMealsAPI
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoconsumeapi.meal.data.model
 *
 */
data class MealFilterResponse(

    @SerializedName("strMeal")
    var strMeal: String? = null,

    @SerializedName("strMealThumb")
    var strMealThumb: String? = null,

    @SerializedName("idMeal")
    var idMeal: String? = null

)