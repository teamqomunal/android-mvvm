package com.qomunal.opensource.androidresearch.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.databinding.ActivityMainBinding
import com.qomunal.opensource.androidresearch.domain.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()
    private val router: MainRouter by lazy {
        MainRouter(this)
    }

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.getNewsArticle()
        }
    }

    override fun initUI() {
        binding.apply {
            
        }
    }

    override fun initObserver() {
        viewModel.apply {
            newsArticlesState.observe(this@MainActivity) {
                when (it) {
                    is Resource.Error -> {
                        Log.d("MainActivity", "Error")
                    }
                    is Resource.Loading -> {
                        Log.d("MainActivity", "Loading")
                    }
                    is Resource.Success -> {
                        Log.d("MainActivity", "Success")
                        Log.d("MainActivity", it.data.toString())
                    }
                }
            }
        }
    }

}