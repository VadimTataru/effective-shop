package com.fox.feature_main_screen.domain.models

data class HotSaleItem(
    val id: Int,
    val isNew: Boolean,
    val title: String,
    val subtitle: String,
    val pictureUri: String,
    val isBuy: Boolean
)
