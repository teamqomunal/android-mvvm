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
data class MealIngredientModel(
    var idIngredient: String = "",
    var strIngredient: String = "",
    var strDescription: String = "",
    var strType: String = ""
) : Parcelable