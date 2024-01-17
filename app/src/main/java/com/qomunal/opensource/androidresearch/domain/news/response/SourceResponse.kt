package com.qomunal.opensource.androidresearch.domain.news.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * Created by Faisal Amir
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 *
 */

@Keep
data class SourceResponse(

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("category")
    var category: String? = null,

    @SerializedName("language")
    var language: String? = null,

    @SerializedName("country")
    var country: String? = null

)