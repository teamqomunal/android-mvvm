package com.qomunal.opensource.androidresearch.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.qomunal.opensource.androidresearch.common.ext.setImageExt
import com.qomunal.opensource.androidresearch.databinding.ItemMainBinding
import com.qomunal.opensource.androidresearch.model.MainModel

/**
 * Created by faisalamircs on 21/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class MainHolder(private val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data : MainModel) {
        binding.apply {
            tvTitle.text = data.title
            tvDesc.text = data.description
            ivImage.setImageExt(data.image)
        }
    }

}