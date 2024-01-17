package com.qomunal.opensource.androidresearch.domain.meal.repository

import com.qomunal.opensource.androidresearch.domain.Resource
import com.qomunal.opensource.androidresearch.domain.meal.mapper.MealMapper
import com.qomunal.opensource.androidresearch.domain.meal.remote.MealRemoteDataSource
import com.qomunal.opensource.androidresearch.model.MealAreaModel
import com.qomunal.opensource.androidresearch.model.MealCategoryModel
import com.qomunal.opensource.androidresearch.model.MealIngredientModel
import com.qomunal.opensource.androidresearch.model.MealModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by faisalamircs on 17/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class MealRepositoryImpl @Inject constructor(
    private val dataSource: MealRemoteDataSource
) : MealRepository {

    override suspend fun searchMeal(nameMeal: String): Flow<Resource<List<MealModel>>> {
        return dataSource.searchMeal(nameMeal).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.meals?.map { meal ->
                        MealMapper.Meal.mapResponseToDomain(meal)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun listAllMeal(firstLetter: String): Flow<Resource<List<MealModel>>> {
        return dataSource.listAllMeal(firstLetter).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.meals?.map { meal ->
                        MealMapper.Meal.mapResponseToDomain(meal)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun lookupFullMeal(idMeal: String): Flow<Resource<List<MealModel>>> {
        return dataSource.lookupFullMeal(idMeal).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.meals?.map { meal ->
                        MealMapper.Meal.mapResponseToDomain(meal)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun lookupRandomMeal(): Flow<Resource<List<MealModel>>> {
        return dataSource.lookupRandomMeal().map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.meals?.map { meal ->
                        MealMapper.Meal.mapResponseToDomain(meal)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun listMealCategories(): Flow<Resource<List<MealCategoryModel>>> {
        return dataSource.listMealCategories().map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.categories?.map { meal ->
                        MealMapper.Category.mapResponseToDomain(meal)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun listAllCategories(query: String): Flow<Resource<List<MealCategoryModel>>> {
        return dataSource.listAllCategories(query).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.meals?.map { meal ->
                        MealMapper.Category.mapResponseToDomain(meal)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun listAllArea(query: String): Flow<Resource<List<MealAreaModel>>> {
        return dataSource.listAllArea(query).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.meals?.map { meal ->
                        MealMapper.Area.mapResponseToDomain(meal)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun listAllIngredients(query: String): Flow<Resource<List<MealIngredientModel>>> {
        return dataSource.listAllIngredients(query).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.meals?.map { meal ->
                        MealMapper.Ingredient.mapResponseToDomain(meal)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun filterByIngredient(ingredient: String): Flow<Resource<List<MealModel>>> {
        return dataSource.filterByIngredient(ingredient).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.meals?.map { meal ->
                        MealMapper.Meal.mapResponseToDomain(meal)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun filterByCategory(category: String): Flow<Resource<List<MealModel>>> {
        return dataSource.filterByCategory(category).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.meals?.map { meal ->
                        MealMapper.Meal.mapResponseToDomain(meal)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun filterByArea(area: String): Flow<Resource<List<MealModel>>> {
        return dataSource.filterByArea(area).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.meals?.map { meal ->
                        MealMapper.Meal.mapResponseToDomain(meal)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

}