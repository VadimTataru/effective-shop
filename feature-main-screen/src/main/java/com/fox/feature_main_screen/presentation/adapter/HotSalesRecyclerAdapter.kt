package com.fox.feature_main_screen.presentation.adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.fox.feature_main_screen.databinding.HotSalesItemBinding
import com.fox.feature_main_screen.domain.models.HotSaleItem

class HotSalesRecyclerAdapter: RecyclerView.Adapter<HotSalesRecyclerAdapter.HotSalesHolder>() {
    private var hotSaleItems = mutableListOf<HotSaleItem>()

    inner class HotSalesHolder(private var itemBinding: HotSalesItemBinding): RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(hotSaleItem: HotSaleItem) {
            hideViewsUntilGlideReady()
            itemBinding.apply {
                Glide.with(imagePlaceholder)
                    .load(hotSaleItem.pictureUri)
                    .listener(object: RequestListener<Drawable?> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: com.bumptech.glide.request.target.Target<Drawable?>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            errorText.visibility = View.VISIBLE
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: com.bumptech.glide.request.target.Target<Drawable?>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            showView()
                            //Заглушка на айфон. Скрыть задник
                            if(hotSaleItem.id == 1) {
                                imageView.visibility = View.INVISIBLE
                            }
                            return false
                        }

                    })
                    .fitCenter()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(imagePlaceholder)

                isNew.visibility = if(hotSaleItem.isNew) View.VISIBLE else View.INVISIBLE
                tvTitle.text = hotSaleItem.title
                tvSubtitle.text = hotSaleItem.subtitle
            }
        }

        private fun showView() {
            itemBinding.apply {
                tvSubtitle.visibility = View.VISIBLE
                tvTitle.visibility = View.VISIBLE
                btnBuy.visibility = View.VISIBLE
                imageView.visibility = View.VISIBLE
            }
        }

        private fun hideViewsUntilGlideReady() {
            itemBinding.apply {
                tvSubtitle.visibility = View.INVISIBLE
                tvTitle.visibility = View.INVISIBLE
                isNew.visibility = View.INVISIBLE
                btnBuy.visibility = View.INVISIBLE
                imageView.visibility = View.INVISIBLE
                errorText.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesHolder {
        val hotSalesItemBinding = HotSalesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotSalesHolder(hotSalesItemBinding)
    }

    override fun onBindViewHolder(holder: HotSalesHolder, position: Int) {
        holder.bind(hotSaleItems[position])
    }

    override fun getItemCount(): Int {
        return hotSaleItems.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setHotSaleList(hotSaleItem: MutableList<HotSaleItem>) {
        hotSaleItems = hotSaleItem
        notifyDataSetChanged()
    }

}