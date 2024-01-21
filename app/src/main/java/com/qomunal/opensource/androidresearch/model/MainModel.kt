package com.qomunal.opensource.androidresearch.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

/**
 * Created by faisalamircs on 21/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Keep
@Parcelize
data class MainModel(
    var title: String,
    var description: String,
    var image: String,
    var data: String,
) : Parcelable

