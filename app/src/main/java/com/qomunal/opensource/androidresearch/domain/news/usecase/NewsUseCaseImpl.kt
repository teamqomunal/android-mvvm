package com.qomunal.opensource.androidresearch.domain.news.usecase

import com.qomunal.opensource.androidresearch.domain.Resource
import com.qomunal.opensource.androidresearch.domain.news.repository.NewsRepository
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant
import com.qomunal.opensource.androidresearch.model.ArticleModel
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


class NewsUseCaseImpl @Inject constructor(
    private val repository: NewsRepository
) : NewsUseCase {

    override suspend fun getTopHeadline(q: String?): Flow<Resource<List<ArticleModel>>> {
        return repository.getTopHeadline(
            q = q,
            sources = null,
            category = null,
            country = NewsConstant.COUNTRY_ID,
            pageSize = null,
            page = null,
        )
    }

}