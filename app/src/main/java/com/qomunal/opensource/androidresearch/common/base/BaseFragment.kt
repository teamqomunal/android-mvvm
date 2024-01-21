package com.qomunal.opensource.androidresearch.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Created by faisalamircs on 21/01/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    companion object {
        val TAG: String = BaseFragment::class.java.simpleName
    }

    private var _binding: VB? = null

    protected val binding: VB get() = _binding!!

    abstract fun setupViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun initUI(savedInstanceState: Bundle?)

    abstract fun initObserver()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = setupViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI(savedInstanceState)
        initObserver()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}