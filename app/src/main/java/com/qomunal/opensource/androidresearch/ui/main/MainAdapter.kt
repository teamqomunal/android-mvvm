package com.qomunal.opensource.androidresearch.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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


class MainAdapter : RecyclerView.Adapter<MainHolder>() {

    var listItems = mutableListOf<MainModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(listItems[position])
    }

    fun setItem(item: MutableList<MainModel>) {
        listItems = item
        notifyDataSetChanged()
    }

}