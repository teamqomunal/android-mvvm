package com.qomunal.opensource.androidresearch.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by faisalamircs on 13/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    private val viewModel: DetailViewModel by viewModels()
    private val reouter: DetailRouter by lazy {
        DetailRouter(this)
    }

    override fun setupViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }


    override fun initUI(savedInstanceState: Bundle?) {
        binding.apply {

        }
    }

    override fun initObserver() {
        viewModel.apply {

        }
    }


}