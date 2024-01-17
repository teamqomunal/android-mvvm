package com.qomunal.opensource.androidresearch.domain.news.repository

import com.qomunal.opensource.androidresearch.domain.Resource
import com.qomunal.opensource.androidresearch.domain.news.mapper.NewsMapper
import com.qomunal.opensource.androidresearch.domain.news.remote.NewsRemoteDataSource
import com.qomunal.opensource.androidresearch.model.ArticleModel
import com.qomunal.opensource.androidresearch.model.SourceModel
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


class NewsRepositoryImpl @Inject constructor(
    private val dataSource: NewsRemoteDataSource
) : NewsRepository {

    override suspend fun getTopHeadline(
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?
    ): Flow<Resource<List<ArticleModel>>> {
        return dataSource.getTopHeadline(q, sources, category, country, pageSize, page).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.articles?.map { article ->
                        NewsMapper.Article.mapResponseToDomain(article)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun getEveryThings(
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
        page: Int?
    ): Flow<Resource<List<ArticleModel>>> {
        return dataSource.getEveryThings(
            q,
            from,
            to,
            qInTitle,
            sources,
            domains,
            excludeDomains,
            language,
            sortBy,
            pageSize,
            page
        ).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.articles?.map { article ->
                        NewsMapper.Article.mapResponseToDomain(article)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun getSources(
        language: String,
        country: String,
        category: String
    ): Flow<Resource<List<SourceModel>>> {
        return dataSource.getSources(language, country, category).map {
            return@map when (it) {
                is Resource.Success -> {
                    val dataSet = it.data?.sources?.map { source ->
                        NewsMapper.Source.mapResponseToDomain(source)
                    }
                    Resource.Success(dataSet ?: listOf())
                }

                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }


}