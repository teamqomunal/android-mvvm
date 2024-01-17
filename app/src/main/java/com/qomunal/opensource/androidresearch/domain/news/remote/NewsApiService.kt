package com.qomunal.opensource.androidresearch.domain.news.remote

import com.google.gson.GsonBuilder
import com.qomunal.opensource.androidresearch.domain.news.response.*
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_API_KEY
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_CATEGORY
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_COUNTRY
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_DOMAINS
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_EXCLUDE_DOMAINS
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_FROM
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_LANGUAGE
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_PAGE
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_PAGE_SIZE
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_Q
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_Q_IN_TITLE
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_SORT_BY
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_SOURCES
import com.qomunal.opensource.androidresearch.domain.news.util.NewsConstant.QUERY_TO
import com.qomunal.opensource.androidresearch.domain.news.util.NewsUrl
import com.qomunal.opensource.androidresearch.domain.news.util.NewsUrl.URL_EVERYTHING
import com.qomunal.opensource.androidresearch.domain.news.util.NewsUrl.URL_SOURCES
import com.qomunal.opensource.androidresearch.domain.news.util.NewsUrl.URL_TOP_HEADLINE
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 *
 */
interface NewsApiService {

    // Get Top Headline
    @GET(URL_TOP_HEADLINE)
    suspend fun getTopHeadline(
        @Query(QUERY_API_KEY) apiKey: String,
        @Query(QUERY_Q) q: String?,
        @Query(QUERY_SOURCES) sources: String?,
        @Query(QUERY_CATEGORY) category: String?,
        @Query(QUERY_COUNTRY) country: String?,
        @Query(QUERY_PAGE_SIZE) pageSize: Int?,
        @Query(QUERY_PAGE) page: Int?
    ): ArticlesResponse

    // Get Everythings
    @GET(URL_EVERYTHING)
    suspend fun getEverythings(
        @Query(QUERY_API_KEY) apiKey: String,
        @Query(QUERY_Q) q: String?,
        @Query(QUERY_FROM) from: String?,
        @Query(QUERY_TO) to: String?,
        @Query(QUERY_Q_IN_TITLE) qInTitle: String?,
        @Query(QUERY_SOURCES) sources: String?,
        @Query(QUERY_DOMAINS) domains: String?,
        @Query(QUERY_EXCLUDE_DOMAINS) excludeDomains: String?,
        @Query(QUERY_LANGUAGE) language: String?,
        @Query(QUERY_SORT_BY) sortBy: String?,
        @Query(QUERY_PAGE_SIZE) pageSize: Int?,
        @Query(QUERY_PAGE) page: Int?
    ): ArticlesResponse

    // Get Sources
    @GET(URL_SOURCES)
    suspend fun getSources(
        @Query(QUERY_API_KEY) apiKey: String,
        @Query(QUERY_LANGUAGE) language: String,
        @Query(QUERY_COUNTRY) country: String,
        @Query(QUERY_CATEGORY) category: String
    ): SourcesResponse

    class Creator {

        @Inject
        fun createApi(
            httpClient: OkHttpClient.Builder,
            converterFactory: Converter.Factory
        ): NewsApiService {
            val retrofit = Retrofit.Builder().baseUrl(NewsUrl.BASE_URL)
                .addConverterFactory(converterFactory)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(httpClient.build())
                .build()

            return retrofit.create(NewsApiService::class.java)
        }
    }

}