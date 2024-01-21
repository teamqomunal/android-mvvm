package com.qomunal.opensource.androidresearch.common.ext

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by faisalamircs on 14/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


inline fun <reified T> fromJson(json: String?): T {
    return Gson().fromJson(json, object : TypeToken<T>() {}.type)
}

inline fun <reified T> T.toJson(): String {
    return Gson().toJson(this)
}