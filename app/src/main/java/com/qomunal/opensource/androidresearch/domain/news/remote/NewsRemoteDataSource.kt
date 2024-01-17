package com.qomunal.opensource.androidresearch.domain.news.remote


import com.qomunal.opensource.androidresearch.domain.Resource
import com.qomunal.opensource.androidresearch.domain.news.response.ArticlesResponse
import com.qomunal.opensource.androidresearch.domain.news.response.SourcesResponse
import com.qomunal.opensource.androidresearch.domain.news.util.NewsUrl
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
class NewsRemoteDataSource @Inject constructor(
    private val apiService: NewsApiService
) {

    private val apiKey = NewsUrl.API_KEY

    // Get Top Headline
    suspend fun getTopHeadline(
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
    ): Flow<Resource<ArticlesResponse>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.getTopHeadline(
                    apiKey,
                    q,
                    sources,
                    category,
                    country,
                    pageSize,
                    page
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


    // Get EveryThings
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
    ): Flow<Resource<ArticlesResponse>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.getEverythings(
                    apiKey,
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

    // Get Sources
    suspend fun getSources(
        language: String,
        country: String,
        category: String,
    ): Flow<Resource<SourcesResponse>> {
        return flow {
            emit(Resource.Loading())
            try {
                val request = apiService.getSources(
                    apiKey,
                    language, country, category
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

}