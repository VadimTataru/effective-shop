package com.fox.effectiveshop.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fox.effectiveshop.databinding.HotSalesItemBinding

class HotSalesRecyclerAdapter(private val imagesArray: IntArray): RecyclerView.Adapter<HotSalesRecyclerAdapter.HotSalesHolder>() {
    private var hotSaleItems = mutableListOf<Int>()

    class HotSalesHolder(var itemBinding: HotSalesItemBinding): RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesHolder {
        val hotSalesItemBinding = HotSalesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotSalesHolder(hotSalesItemBinding)
    }

    override fun onBindViewHolder(holder: HotSalesHolder, position: Int) {
        holder.itemBinding.imagePlaceholder.setImageResource(imagesArray[position])
    }

    override fun getItemCount(): Int {
        return imagesArray.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setHotSaleList() {

        notifyDataSetChanged()
    }

}