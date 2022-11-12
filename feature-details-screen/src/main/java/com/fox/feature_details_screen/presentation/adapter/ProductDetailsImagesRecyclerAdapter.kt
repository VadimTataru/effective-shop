package com.fox.feature_details_screen.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fox.feature_details_screen.databinding.ProductDetailsImagesItemBinding

class ProductDetailsImagesRecyclerAdapter: RecyclerView.Adapter<ProductDetailsImagesRecyclerAdapter.ProductDetailsViewHolder>() {
    private var images = mutableListOf<String>()

    inner class ProductDetailsViewHolder(private val binding: ProductDetailsImagesItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUri: String) {
            binding.apply {
                Glide.with(imagePlaceholder)
                    .load(imageUri)
                    .into(imagePlaceholder)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailsViewHolder {
        val binding = ProductDetailsImagesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductDetailsViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setImages(imageUris: MutableList<String>) {
        images = imageUris
        notifyDataSetChanged()
    }
}