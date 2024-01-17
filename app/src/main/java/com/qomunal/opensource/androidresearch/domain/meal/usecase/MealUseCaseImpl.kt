package com.qomunal.opensource.androidresearch.domain.meal.usecase

import com.qomunal.opensource.androidresearch.domain.Resource
import com.qomunal.opensource.androidresearch.domain.meal.repository.MealRepository
import com.qomunal.opensource.androidresearch.model.MealAreaModel
import com.qomunal.opensource.androidresearch.model.MealCategoryModel
import com.qomunal.opensource.androidresearch.model.MealIngredientModel
import com.qomunal.opensource.androidresearch.model.MealModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by faisalamircs on 17/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class MealUseCaseImpl @Inject constructor(
    private val repository: MealRepository
) : MealUseCase {
    
    override suspend fun searchMeal(nameMeal: String): Flow<Resource<List<MealModel>>> {
        return repository.searchMeal(nameMeal)
    }

    override suspend fun listAllMeal(firstLetter: String): Flow<Resource<List<MealModel>>> {
        return repository.listAllMeal(firstLetter)
    }

    override suspend fun lookupFullMeal(idMeal: String): Flow<Resource<List<MealModel>>> {
        return repository.lookupFullMeal(idMeal)
    }

    override suspend fun lookupRandomMeal(): Flow<Resource<List<MealModel>>> {
        return repository.lookupRandomMeal()
    }

    override suspend fun listMealCategories(): Flow<Resource<List<MealCategoryModel>>> {
        return repository.listMealCategories()
    }

    override suspend fun listAllCategories(query: String): Flow<Resource<List<MealCategoryModel>>> {
        return repository.listAllCategories(query)
    }

    override suspend fun listAllArea(query: String): Flow<Resource<List<MealAreaModel>>> {
        return repository.listAllArea(query)
    }

    override suspend fun listAllIngredients(query: String): Flow<Resource<List<MealIngredientModel>>> {
        return repository.listAllIngredients(query)
    }

    override suspend fun filterByIngredient(ingredient: String): Flow<Resource<List<MealModel>>> {
        return repository.filterByIngredient(ingredient)
    }

    override suspend fun filterByCategory(category: String): Flow<Resource<List<MealModel>>> {
        return repository.filterByCategory(category)
    }

    override suspend fun filterByArea(area: String): Flow<Resource<List<MealModel>>> {
        return repository.filterByArea(area)
    }

}