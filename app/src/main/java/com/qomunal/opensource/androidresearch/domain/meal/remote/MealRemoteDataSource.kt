package com.qomunal.opensource.androidresearch.domain.meal.remote

import com.qomunal.opensource.androidresearch.domain.Resource
import com.qomunal.opensource.androidresearch.domain.meal.response.AreaResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.CategoriesResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.CategoryResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.IngredientResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.MealResponse
import com.qomunal.opensource.androidresearch.domain.meal.response.MealsResponse
import com.qomunal.opensource.androidresearch.domain.meal.util.MealUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by faisalamircs on 14/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Singleton
class MealRemoteDataSource @Inject constructor(
    private val apiService: MealApiService
) {
    
    private val apiKey = MealUrl.API_KEY

    suspend fun searchMeal(
        nameMeal: String
    ): Flow<Resource<MealsResponse<MealResponse>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.searchMeal(
                    apiKey,
                    nameMeal
                )
                emit(Resource.Success(request))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }

    // List all meals by first letter
    suspend fun listAllMeal(
        firstLetter: String
    ): Flow<Resource<MealsResponse<MealResponse>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.listAllMeal(
                    apiKey,
                    firstLetter
                )
                emit(Resource.Success(request))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }

    // Lookup full meal details by id
    suspend fun lookupFullMeal(
        idMeal: String
    ): Flow<Resource<MealsResponse<MealResponse>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.lookupFullMeal(
                    apiKey,
                    idMeal
                )
                emit(Resource.Success(request))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }

    // Lookup a single random meal
    suspend fun lookupRandomMeal(): Flow<Resource<MealsResponse<MealResponse>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.lookupRandomMeal(apiKey)
                emit(Resource.Success(request))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }

    // List all meal categories
    suspend fun listMealCategories(): Flow<Resource<CategoriesResponse>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.listMealCategories(apiKey)
                emit(Resource.Success(request))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }

    // List all Categories
    suspend fun listAllCategories(
        query: String
    ): Flow<Resource<MealsResponse<CategoryResponse>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.listAllCategories(apiKey, query)
                emit(Resource.Success(request))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }

    // List all Area
    suspend fun listAllArea(
        query: String
    ): Flow<Resource<MealsResponse<AreaResponse>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.listAllArea(apiKey, query)
                emit(Resource.Success(request))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }

    // List all Ingredients
    suspend fun listAllIngredients(
        query: String
    ): Flow<Resource<MealsResponse<IngredientResponse>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.listAllIngredients(apiKey, query)
                emit(Resource.Success(request))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }

    // Filter by main ingredient
    suspend fun filterByIngredient(
        ingredient: String
    ): Flow<Resource<MealsResponse<MealResponse>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.filterByIngredient(apiKey, ingredient)
                emit(Resource.Success(request))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }

    // Filter by Category
    suspend fun filterByCategory(
        category: String
    ): Flow<Resource<MealsResponse<MealResponse>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.filterByCategory(apiKey, category)
                emit(Resource.Success(request))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }

    // Filter by Area
    suspend fun filterByArea(
        area: String
    ): Flow<Resource<MealsResponse<MealResponse>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.filterByArea(apiKey, area)
                emit(Resource.Success(request))
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message.toString()))
            }
    }

}