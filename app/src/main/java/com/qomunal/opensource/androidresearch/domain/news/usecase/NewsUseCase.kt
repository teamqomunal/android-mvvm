package com.qomunal.opensource.androidresearch.domain.news.usecase

import com.qomunal.opensource.androidresearch.domain.Resource
import com.qomunal.opensource.androidresearch.model.ArticleModel
import kotlinx.coroutines.flow.Flow

/**
 * Created by faisalamircs on 17/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


interface NewsUseCase {

    suspend fun getTopHeadline(
        q: String?
    ): Flow<Resource<List<ArticleModel>>>

}