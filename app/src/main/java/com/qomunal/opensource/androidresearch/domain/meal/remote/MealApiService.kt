package com.qomunal.opensource.androidresearch.domain.meal.remote


import com.google.gson.GsonBuilder
import com.qomunal.opensource.androidresearch.domain.meal.response.*
import com.qomunal.opensource.androidresearch.domain.meal.util.MealConstant
import com.qomunal.opensource.androidresearch.domain.meal.util.MealUrl
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * consumable-code-the-meal-db-api
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogomealsapi.data.source
 *
 */
interface MealApiService {

    // Search meal by name
    @GET(MealUrl.URL_SEARCH_MEAL)
    suspend fun searchMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_NAME) nameMeal: String
    ): MealsResponse<MealResponse>

    // List all meals by first letter
    @GET(MealUrl.URL_SEARCH_MEAL)
    suspend fun listAllMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_FIRST_LETTER) firstLetter: String
    ): MealsResponse<MealResponse>

    // Lookup full meal details by id
    @GET(MealUrl.URL_LOOKUP_MEAL)
    suspend fun lookupFullMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_ID) idMeal: String
    ): MealsResponse<MealResponse>

    // Lookup a single random meal
    @GET(MealUrl.URL_RANDOM_MEAL)
    suspend fun lookupRandomMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String
    ): MealsResponse<MealResponse>

    // List all meal categories
    @GET(MealUrl.URL_CATEGORIES)
    suspend fun listMealCategories(
        @Path(MealConstant.PATH_API_KEY) apiKey: String
    ): CategoriesResponse

    // List all Categories
    @GET(MealUrl.URL_LIST)
    suspend fun listAllCategories(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_CATEGORY) query: String
    ): MealsResponse<CategoryResponse>

    // List all Area
    @GET(MealUrl.URL_LIST)
    suspend fun listAllArea(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_AREA) query: String
    ): MealsResponse<AreaResponse>

    // List all Ingredients
    @GET(MealUrl.URL_LIST)
    suspend fun listAllIngredients(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_INGREDIENT) query: String
    ): MealsResponse<IngredientResponse>

    // Filter by main ingredient
    @GET(MealUrl.URL_FILTER)
    suspend fun filterByIngredient(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_INGREDIENT) ingredient: String
    ): MealsResponse<MealResponse>

    // Filter by Category
    suspend fun filterByCategory(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_CATEGORY) category: String
    ): MealsResponse<MealResponse>

    // Filter by Area
    suspend fun filterByArea(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_AREA) area: String
    ): MealsResponse<MealResponse>

    class Creator {
        @Inject
        fun createApi(httpClient: OkHttpClient.Builder, converterFactory: Converter.Factory): MealApiService {
            val retrofit = Retrofit.Builder().baseUrl(MealUrl.BASE_URL)
                .addConverterFactory(converterFactory)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(httpClient.build())
                .build()

            return retrofit.create(MealApiService::class.java)
        }
    }

}