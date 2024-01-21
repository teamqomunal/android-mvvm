package com.qomunal.opensource.androidresearch.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.qomunal.opensource.androidresearch.R
import com.qomunal.opensource.androidresearch.common.base.BaseActivity
import com.qomunal.opensource.androidresearch.databinding.ActivityMainBinding
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

    override fun initUI(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            replaceFragment(MainFragment.newInstance(MainMenuType.NEWS))
        }

        binding.apply {
            bottomNav.setOnItemSelectedListener {
                when (it.itemId) {

                    R.id.nv_news -> {
                        replaceFragment(MainFragment.newInstance(MainMenuType.NEWS))
                        return@setOnItemSelectedListener true
                    }

                    R.id.nv_meal -> {
                        replaceFragment(MainFragment.newInstance(MainMenuType.MEAL))
                        return@setOnItemSelectedListener true
                    }

                }
                return@setOnItemSelectedListener false
            }

        }
    }

    override fun initObserver() {
        viewModel.apply {

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val backStateName: String = fragment::class.java.name
        val manager: FragmentManager = supportFragmentManager
        val fragmentPopped: Boolean = manager.popBackStackImmediate(backStateName, 0)
        if (!fragmentPopped) { //fragment not in back stack, create it.
            val ft: FragmentTransaction = manager.beginTransaction()
            ft.replace(binding.fragmentMain.id, fragment)
            ft.addToBackStack(backStateName)
            ft.commit()
        }
    }

}