package com.qomunal.opensource.androidresearch.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

/**
 * Created by faisalamircs on 15/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */

@Keep
@Parcelize
data class SourceModel(
    var id: String = "",
    var name: String = "",
    var description: String = "",
    var url: String = "",
    var category: String = "",
    var language: String = "",
    var country: String = ""
) : Parcelable