package com.fox.feature_details_screen.presentation.fragments

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.fox.core_ui.navigation.DeepLinks
import com.fox.core_ui.navigation.NavOptions
import com.fox.core_ui.presentation.BaseFragment
import com.fox.core_ui.utils.SpacingItemDecorator
import com.fox.core_ui.utils.SpacingType
import com.fox.feature_details_screen.R
import com.fox.feature_details_screen.presentation.adapter.ProductDetailsImagesRecyclerAdapter
import com.fox.feature_details_screen.presentation.adapter.DetailsViewPagerAdapter
import com.fox.feature_details_screen.presentation.adapter.DetailsViewPagerAdapter.Companion.DETAILS_FRAGMENT
import com.fox.feature_details_screen.presentation.adapter.DetailsViewPagerAdapter.Companion.DETAILS_SHOP_FRAGMENT
import com.fox.feature_details_screen.presentation.adapter.DetailsViewPagerAdapter.Companion.FEATURES_FRAGMENT
import com.fox.feature_details_screen.presentation.viewmodel.DetailsScreenViewModel
import com.fox.feature_details_screen.databinding.FragmentProductDetailsBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import kotlin.math.abs
import kotlin.math.roundToInt

class ProductDetailsFragment : BaseFragment() {
    private lateinit var binding: FragmentProductDetailsBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: DetailsScreenViewModel

    private lateinit var productDetailsImagesRecyclerAdapter: ProductDetailsImagesRecyclerAdapter
    private lateinit var detailsViewPagerAdapter: DetailsViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailsScreenViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProductDetails()
        initAdapters()
        setImagesToRecyclerView()
        initViews()
    }

    private fun initAdapters() {
        productDetailsImagesRecyclerAdapter = ProductDetailsImagesRecyclerAdapter()
        detailsViewPagerAdapter = DetailsViewPagerAdapter(childFragmentManager, lifecycle)
        binding.apply {
            setupViewPager()
            productDetailsView.detailsViewPager.adapter = detailsViewPagerAdapter

            TabLayoutMediator(productDetailsView.tabLayout, productDetailsView.detailsViewPager){ tab, position ->
                when (position) {
                    DETAILS_SHOP_FRAGMENT -> tab.text = getString(R.string.pager_shop)
                    DETAILS_FRAGMENT -> tab.text = getString(R.string.pager_details)
                    FEATURES_FRAGMENT -> tab.text = getString(R.string.pager_features)
                }
            }.attach()
        }
    }

    private fun setImagesToRecyclerView() {
        viewModel.getImages().observe(viewLifecycleOwner) {
            if(it != null)
                productDetailsImagesRecyclerAdapter.setImages(it.toMutableList())
        }
    }

    @SuppressLint("InflateParams")
    private fun initViews() {
            viewModel.getDetailsInfo().observe(viewLifecycleOwner) {
            if(it != null) {
                binding.productDetailsView.apply {
                    tvTitle.text = it.title
                    appCompatRatingBar.rating = it.rating
                }
            }
        }

        viewModel.getFavoriteState().observe(viewLifecycleOwner) {
            if(it != null) {
                binding.productDetailsView.apply {
                    imBtnFav.setImageResource(if(it) R.drawable.ic_filled_heart_white else R.drawable.ic_outlined_heart_white)
                    imBtnFav.setOnClickListener {
                        viewModel.fakeFavouriteEvent()
                    }
                }
            }
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnCart.setOnClickListener {
            navigateTo(getString(DeepLinks.CART_SCREEN))
        }
    }

    private fun setupViewPager() {
        binding.imagesSpinner.apply {
            adapter = productDetailsImagesRecyclerAdapter
            offscreenPageLimit = 1
            val nextItemVisiblePx = 26
            val currentItemHorizontalMarginPx = 42
            val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
            val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
                page.translationX = -pageTranslationX * position
                page.scaleY = 1 - (0.25f * abs(position))
                page.alpha = 0.25f + (1 - abs(position))
            }
            setPageTransformer(pageTransformer)
            val itemDecoration = SpacingItemDecorator(42, SpacingType.Horizontal)
            addItemDecoration(itemDecoration)
        }
    }
}