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
            val ingredients = mutableListOf<String>()
            ingredients.add(input.strIngredient1 ?: "")
            ingredients.add(input.strIngredient2 ?: "")
            ingredients.add(input.strIngredient3 ?: "")
            ingredients.add(input.strIngredient4 ?: "")
            ingredients.add(input.strIngredient5 ?: "")
            ingredients.add(input.strIngredient6 ?: "")
            ingredients.add(input.strIngredient7 ?: "")
            ingredients.add(input.strIngredient8 ?: "")
            ingredients.add(input.strIngredient9 ?: "")
            ingredients.add(input.strIngredient10 ?: "")
            ingredients.add(input.strIngredient11 ?: "")
            ingredients.add(input.strIngredient12 ?: "")
            ingredients.add(input.strIngredient13 ?: "")
            ingredients.add(input.strIngredient14 ?: "")
            ingredients.add(input.strIngredient15 ?: "")
            ingredients.add(input.strIngredient16 ?: "")
            ingredients.add(input.strIngredient17 ?: "")
            ingredients.add(input.strIngredient18 ?: "")
            ingredients.add(input.strIngredient19 ?: "")
            ingredients.add(input.strIngredient20 ?: "")

            val measurements = mutableListOf<String>()
            measurements.add(input.strMeasure1 ?: "")
            measurements.add(input.strMeasure2 ?: "")
            measurements.add(input.strMeasure3 ?: "")
            measurements.add(input.strMeasure4 ?: "")
            measurements.add(input.strMeasure5 ?: "")
            measurements.add(input.strMeasure6 ?: "")
            measurements.add(input.strMeasure7 ?: "")
            measurements.add(input.strMeasure8 ?: "")
            measurements.add(input.strMeasure9 ?: "")
            measurements.add(input.strMeasure10 ?: "")
            measurements.add(input.strMeasure11 ?: "")
            measurements.add(input.strMeasure12 ?: "")
            measurements.add(input.strMeasure13 ?: "")
            measurements.add(input.strMeasure14 ?: "")
            measurements.add(input.strMeasure15 ?: "")
            measurements.add(input.strMeasure16 ?: "")
            measurements.add(input.strMeasure17 ?: "")
            measurements.add(input.strMeasure18 ?: "")
            measurements.add(input.strMeasure19 ?: "")
            measurements.add(input.strMeasure20 ?: "")

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
                strIngredient = ingredients.filter { it != "" },
                strMeasure = measurements.filter { it != "" },
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