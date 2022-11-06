package com.fox.effectiveshop.presentation.models

data class Category(
    val categoryTitle: String,
    val categoryIcon: Int,
    val selectedCategoryIcon: Int,
    var isSelected: Boolean
) {
}