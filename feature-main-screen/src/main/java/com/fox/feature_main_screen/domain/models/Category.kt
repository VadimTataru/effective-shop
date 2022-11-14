package com.fox.feature_main_screen.domain.models

data class Category(
    val categoryTitle: String,
    val categoryIcon: Int,
    val selectedCategoryIcon: Int,
    var isSelected: Boolean
)