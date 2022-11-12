package com.fox.feature_main_screen.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fox.core_ui.R
import com.fox.feature_main_screen.presentation.delegates.BestSellerDelegate
import com.fox.feature_main_screen.databinding.BestSellerItemBinding
import com.fox.feature_main_screen.domain.models.BestSellerItem

class BestSellerRecyclerAdapter(
    private val bestSellersDelegate: BestSellerDelegate
): RecyclerView.Adapter<BestSellerRecyclerAdapter.BestSellerViewHolder>() {
    private var bestSellerItems = mutableListOf<BestSellerItem>()

    inner class BestSellerViewHolder(private var itemBinding: BestSellerItemBinding): RecyclerView.ViewHolder(itemBinding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(bestSellerItem: BestSellerItem) {
            itemBinding.apply {
                Glide.with(imPhone)
                    .load(bestSellerItem.pictureUri)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(imPhone)

                priceWithDiscount.text = "$" + bestSellerItem.priceWithDiscount.toString()
                priceWithoutDiscount.text = bestSellerItem.priceWithoutDiscount.toString()
                title.text = bestSellerItem.title

                btnFavourite.setImageResource(
                    if(bestSellerItem.isFavourite)
                        R.drawable.ic_filled
                    else
                        R.drawable.ic_outlined
                )
            }

            this.itemView.setOnClickListener {
                bestSellersDelegate.onBestSellerViewClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val binding = BestSellerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BestSellerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.bind(bestSellerItems[position])
    }

    override fun getItemCount(): Int {
        return bestSellerItems.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setBestSellerList(bestSellerItemList: MutableList<BestSellerItem>) {
        bestSellerItems = bestSellerItemList
        notifyDataSetChanged()
    }
}