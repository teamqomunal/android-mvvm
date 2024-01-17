package com.qomunal.opensource.androidresearch.domain.meal.repository

import com.qomunal.opensource.androidresearch.domain.Resource
import com.qomunal.opensource.androidresearch.domain.meal.response.AreaResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.CategoriesResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.CategoryResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.IngredientResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.MealResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.MealsResponse
import com.qomunal.opensource.androidresearch.model.MealAreaModel
import com.qomunal.opensource.androidresearch.model.MealCategoryModel
import com.qomunal.opensource.androidresearch.model.MealIngredientModel
import com.qomunal.opensource.androidresearch.model.MealModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by faisalamircs on 17/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


interface MealRepository {

    suspend fun searchMeal(
        nameMeal: String
    ): Flow<Resource<List<MealModel>>>

    // List all meals by first letter
    suspend fun listAllMeal(
        firstLetter: String
    ): Flow<Resource<List<MealModel>>>

    // Lookup full meal details by id
    suspend fun lookupFullMeal(
        idMeal: String
    ): Flow<Resource<List<MealModel>>>

    // Lookup a single random meal
    suspend fun lookupRandomMeal(): Flow<Resource<List<MealModel>>>

    // List all meal categories
    suspend fun listMealCategories(): Flow<Resource<List<MealCategoryModel>>>

    // List all Categories
    suspend fun listAllCategories(
        query: String
    ): Flow<Resource<List<MealCategoryModel>>>

    // List all Area
    suspend fun listAllArea(
        query: String
    ): Flow<Resource<List<MealAreaModel>>>

    // List all Ingredients
    suspend fun listAllIngredients(
        query: String
    ): Flow<Resource<List<MealIngredientModel>>>

    // Filter by main ingredient
    suspend fun filterByIngredient(
        ingredient: String
    ): Flow<Resource<List<MealModel>>>

    // Filter by Category
    suspend fun filterByCategory(
        category: String
    ): Flow<Resource<List<MealModel>>>

    // Filter by Area
    suspend fun filterByArea(
        area: String
    ): Flow<Resource<List<MealModel>>>

}