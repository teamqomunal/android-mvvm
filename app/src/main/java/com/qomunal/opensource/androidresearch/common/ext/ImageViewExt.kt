package com.qomunal.opensource.androidresearch.common.ext

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.qomunal.opensource.androidresearch.R

/**
 * Created by faisalamircs on 21/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


fun ImageView.setImageExt(
    uri: Any? = null,
    placeHolder: Int = R.drawable.ic_launcher_background,
    isCenterCrop: Boolean = false
) {
    if (uri != null) {
        when (uri) {
            is String,
            is Int,
            is Uri,
            is ByteArray -> {
                if (isCenterCrop) {
                    Glide.with(context)
                        .load(uri)
                        .placeholder(placeHolder)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop()
                        .into(this)
                } else {
                    Glide.with(context)
                        .load(uri)
                        .placeholder(placeHolder)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(this)
                }

            }
        }
    } else {
        Glide.with(context)
            .load("")
            .placeholder(placeHolder)
            .into(this)
    }
}