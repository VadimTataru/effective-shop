package com.fox.feature_cart_screen.presentation.delegates

interface BasketItemDelegate {
    fun onClickMinus()
    fun onClickPlus()
    fun onClickTrash(id: Int)
}