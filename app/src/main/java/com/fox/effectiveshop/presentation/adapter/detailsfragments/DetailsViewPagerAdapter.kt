package com.fox.effectiveshop.presentation.adapter.detailsfragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailsViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments = listOf(
        DetailsShopFragment(),
        DetailsFragment(),
        FeaturesFragment()
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    companion object {
        const val DETAILS_SHOP_FRAGMENT = 0
        const val DETAILS_FRAGMENT = 1
        const val FEATURES_FRAGMENT = 2
    }
}