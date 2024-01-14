package com.qomunal.opensource.androidresearch

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by faisalamircs on 13/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@HiltAndroidApp
class QomunalApp : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: QomunalApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }


    }

    override fun onCreate() {
        super.onCreate()
    }

}