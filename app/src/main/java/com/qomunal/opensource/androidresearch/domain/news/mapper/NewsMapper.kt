package com.qomunal.opensource.androidresearch.domain.news.mapper

import com.qomunal.opensource.androidresearch.domain.news.response.ArticleResponse
import com.qomunal.opensource.androidresearch.domain.news.response.SourceResponse
import com.qomunal.opensource.androidresearch.model.ArticleModel
import com.qomunal.opensource.androidresearch.model.SourceModel

/**
 * Created by faisalamircs on 15/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


object NewsMapper {

    object Source {
        fun mapResponseToDomain(input: SourceResponse): SourceModel {
            return SourceModel(
                id = input.id ?: "",
                name = input.name ?: "",
                description = input.description ?: "",
                url = input.url ?: "",
                category = input.category ?: "",
                language = input.language ?: "",
                country = input.country ?: ""
            )
        }
    }

    object Article {

        fun mapResponseToDomain(input: ArticleResponse): ArticleModel {
            return ArticleModel(
                source = Source.mapResponseToDomain(input.source ?: SourceResponse()),
                author = input.author ?: "",
                title = input.title ?: "",
                description = input.description ?: "",
                url = input.url ?: "",
                urlToImage = input.urlToImage ?: "",
                publishedAt = input.publishedAt ?: "",
                content = input.content ?: ""
            )
        }

    }


}