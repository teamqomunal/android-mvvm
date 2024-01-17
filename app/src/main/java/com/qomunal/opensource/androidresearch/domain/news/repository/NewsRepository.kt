package com.qomunal.opensource.androidresearch.domain.news.repository

import com.qomunal.opensource.androidresearch.domain.Resource
import com.qomunal.opensource.androidresearch.model.ArticleModel
import com.qomunal.opensource.androidresearch.model.SourceModel
import kotlinx.coroutines.flow.Flow

/**
 * Created by faisalamircs on 17/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


interface NewsRepository {

    suspend fun getTopHeadline(
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
    ): Flow<Resource<List<ArticleModel>>>

    suspend fun getEveryThings(
        q: String?,
        from: String?,
        to: String?,
        qInTitle: String?,
        sources: String?,
        domains: String?,
        excludeDomains: String?,
        language: String?,
        sortBy: String?,
        pageSize: Int?,
        page: Int?,
    ): Flow<Resource<List<ArticleModel>>>

    suspend fun getSources(
        language: String,
        country: String,
        category: String,
    ): Flow<Resource<List<SourceModel>>>

}