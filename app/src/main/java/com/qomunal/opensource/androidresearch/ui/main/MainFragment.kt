package com.qomunal.opensource.androidresearch.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qomunal.opensource.androidresearch.common.base.BaseFragment
import com.qomunal.opensource.androidresearch.databinding.FragmentMainBinding
import com.qomunal.opensource.androidresearch.domain.Resource
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by faisalamircs on 21/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {

    companion object {

        const val EXTRA_MENU = "EXTRA_MENU"

        fun newInstance(menu: MainMenuType): MainFragment {
            return MainFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_MENU, menu.name)
                }

            }
        }
    }

    private val viewModel: MainViewModel by activityViewModels()

    private var mainAdapter = MainAdapter()

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun initUI(savedInstanceState: Bundle?) {
        val menu = MainMenuType.valueOf(arguments?.getString(EXTRA_MENU) ?: "")

        if (savedInstanceState == null) {
            when (menu) {
                MainMenuType.NEWS -> {
                    viewModel.getNewsArticle()
                }

                MainMenuType.MEAL -> {
                    viewModel.getMeals()
                }
            }
        }

        binding.apply {

            rvMain.apply {
                val layout = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                adapter = mainAdapter
                layoutManager = layout
            }
        }
    }

    override fun initObserver() {
        viewModel.apply {
            newsArticlesState.observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Error -> {

                    }

                    is Resource.Loading -> {

                    }

                    is Resource.Success -> {
                        val data = it.data?.map { setData ->
                            MainMapper.articleMapper(setData)
                        }?.toMutableList() ?: mutableListOf()
                        mainAdapter.setItem(data)
                    }
                }
            }

            mealState.observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Error -> {

                    }

                    is Resource.Loading -> {

                    }

                    is Resource.Success -> {
                        val data = it.data?.map { setData ->
                            MainMapper.mealMapper(setData)
                        }?.toMutableList() ?: mutableListOf()
                        mainAdapter.setItem(data)
                    }
                }
            }
        }
    }
}