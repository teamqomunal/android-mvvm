package com.qomunal.opensource.androidresearch.domain.meal.mapper

import com.qomunal.opensource.androidresearch.domain.meal.response.AreaResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.CategoryResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.IngredientResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.MealResponse
import com.qomunal.opensource.androidresearch.model.MealAreaModel
import com.qomunal.opensource.androidresearch.model.MealCategoryModel
import com.qomunal.opensource.androidresearch.model.MealIngredientModel
import com.qomunal.opensource.androidresearch.model.MealModel

/**
 * Created by faisalamircs on 17/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


object MealMapper {

    object Meal {
        fun mapResponseToDomain(input: MealResponse): MealModel {
            return MealModel(
                idMeal = input.idMeal ?: "",
                strMeal = input.strMeal ?: "",
                strDrinkAlternate = input.strDrinkAlternate ?: "",
                strCategory = input.strCategory ?: "",
                strArea = input.strArea ?: "",
                strInstructions = input.strInstructions ?: "",
                strMealThumb = input.strMealThumb ?: "",
                strTags = input.strTags ?: "",
                strYoutube = input.strYoutube ?: "",
                strIngredient1 = input.strIngredient1 ?: "",
                strIngredient2 = input.strIngredient2 ?: "",
                strIngredient3 = input.strIngredient3 ?: "",
                strIngredient4 = input.strIngredient4 ?: "",
                strIngredient5 = input.strIngredient5 ?: "",
                strIngredient6 = input.strIngredient6 ?: "",
                strIngredient7 = input.strIngredient7 ?: "",
                strIngredient8 = input.strIngredient8 ?: "",
                strIngredient9 = input.strIngredient9 ?: "",
                strIngredient10 = input.strIngredient10 ?: "",
                strIngredient11 = input.strIngredient11 ?: "",
                strIngredient12 = input.strIngredient12 ?: "",
                strIngredient13 = input.strIngredient13 ?: "",
                strIngredient14 = input.strIngredient14 ?: "",
                strIngredient15 = input.strIngredient15 ?: "",
                strIngredient16 = input.strIngredient16 ?: "",
                strIngredient17 = input.strIngredient17 ?: "",
                strIngredient18 = input.strIngredient18 ?: "",
                strIngredient19 = input.strIngredient19 ?: "",
                strIngredient20 = input.strIngredient20 ?: "",
                strMeasure1 = input.strMeasure1 ?: "",
                strMeasure2 = input.strMeasure2 ?: "",
                strMeasure3 = input.strMeasure3 ?: "",
                strMeasure4 = input.strMeasure4 ?: "",
                strMeasure5 = input.strMeasure5 ?: "",
                strMeasure6 = input.strMeasure6 ?: "",
                strMeasure7 = input.strMeasure7 ?: "",
                strMeasure8 = input.strMeasure8 ?: "",
                strMeasure9 = input.strMeasure9 ?: "",
                strMeasure10 = input.strMeasure10 ?: "",
                strMeasure11 = input.strMeasure11 ?: "",
                strMeasure12 = input.strMeasure12 ?: "",
                strMeasure13 = input.strMeasure13 ?: "",
                strMeasure14 = input.strMeasure14 ?: "",
                strMeasure15 = input.strMeasure15 ?: "",
                strMeasure16 = input.strMeasure16 ?: "",
                strMeasure17 = input.strMeasure17 ?: "",
                strMeasure18 = input.strMeasure18 ?: "",
                strMeasure19 = input.strMeasure19 ?: "",
                strMeasure20 = input.strMeasure20 ?: "",
                strSource = input.strSource ?: "",
                dateModified = input.dateModified ?: ""
            )
        }
    }

    object Area {
        fun mapResponseToDomain(input: AreaResponse): MealAreaModel {
            return MealAreaModel(
                strArea = input.strArea ?: ""
            )
        }
    }

    object Category {
        fun mapResponseToDomain(input: CategoryResponse): MealCategoryModel {
            return MealCategoryModel(
                id = input.idCategory ?: "",
                category = input.strCategory ?: "",
                thumb = input.strCategoryThumb ?: "",
                description = input.strCategoryDescription ?: ""
            )
        }
    }

    object Ingredient {
        fun mapResponseToDomain(input: IngredientResponse): MealIngredientModel {
            return MealIngredientModel(
                idIngredient = input.idIngredient ?: "",
                strIngredient = input.strIngredient ?: "",
                strDescription = input.strDescription ?: "",
                strType = input.strType ?: ""
            )
        }
    }

}