package com.fox.feature_cart_screen.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fox.feature_cart_screen.databinding.CartItemBinding
import com.fox.feature_cart_screen.domain.models.BasketItem
import com.fox.feature_cart_screen.presentation.delegates.BasketItemDelegate

class BasketRecyclerAdapter(
    private val delegate: BasketItemDelegate
): RecyclerView.Adapter<BasketRecyclerAdapter.BasketViewHolder>() {
    private var basketItems = mutableListOf<BasketItem>()

    inner class BasketViewHolder(private val binding: CartItemBinding): RecyclerView.ViewHolder(binding.root) {
        private var count: Int = 1;

        fun bind(basketItem: BasketItem) {
            binding.apply {
                Glide.with(imgProduct)
                    .load(basketItem.image)
                    .centerCrop()
                    .into(imgProduct)
                tvTitle.text = basketItem.title
                tvPrice.text = "$" + basketItem.price.toString()

                btnMinus.setOnClickListener {
                    if(count < 0)
                        count -= 1
                    delegate.onClickMinus()
                }
                btnPlus.setOnClickListener {
                    count += 1
                    delegate.onClickPlus()
                }
                btnTrash.setOnClickListener {
                    delegate.onClickTrash(basketItem.id)
                }
                tvCount.text = count.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BasketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.bind(basketItems[position])
    }

    override fun getItemCount(): Int {
        return basketItems.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setBasketItemList(list: MutableList<BasketItem>) {
        basketItems = list
        notifyDataSetChanged()
    }

    fun addBasketItem(id: Int) {
    }
}