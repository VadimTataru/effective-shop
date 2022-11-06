package com.fox.effectiveshop.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fox.effectiveshop.R
import com.fox.effectiveshop.databinding.CategoryItemBinding
import com.fox.effectiveshop.presentation.models.Category

class CategoryRecyclerAdapter: RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>() {
    private var categories = mutableListOf<Category>()

    inner class CategoryViewHolder(private val binding: CategoryItemBinding, private val context: Context): RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.apply {
                if(category.isSelected) {
                    imageButton.setImageResource(category.selectedCategoryIcon)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        tvCategory.setTextAppearance(R.style.OrangeText)
                    }
                } else {
                    imageButton.setImageResource(category.categoryIcon)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        tvCategory.setTextAppearance(R.style.DarkBlueCommonText)
                    }
                }
                tvCategory.text = category.categoryTitle
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(category = categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCategories(categories: MutableList<Category>) {
        this.categories = categories
        notifyDataSetChanged()
    }
}