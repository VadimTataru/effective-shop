package com.fox.feature_details_screen.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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

class ProductDetailsFragment : Fragment() {
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
        initAdapters()
        setImagesToRecyclerView()
        initViews()
    }

    private fun initAdapters() {
        productDetailsImagesRecyclerAdapter = ProductDetailsImagesRecyclerAdapter()
        detailsViewPagerAdapter = DetailsViewPagerAdapter(childFragmentManager, lifecycle)
        binding.apply {
            imagesSpinner.adapter = productDetailsImagesRecyclerAdapter
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
        viewModel.getProductDetails()
        viewModel.getImages().observe(viewLifecycleOwner) {
            if(it != null)
                productDetailsImagesRecyclerAdapter.setImages(it.toMutableList())
        }
    }

    @SuppressLint("InflateParams")
    private fun initViews() {
        /*viewModel.getDetailsInfo().observe(viewLifecycleOwner) {
            if(it != null) {
                binding.productDetailsView.apply {
                    tvTitle.text = it.title
                    appCompatRatingBar.rating = it.rating
                    *//*tvCore.text = it.cpu
                    tvCamera.text = it.camera
                    tvSsd.text = it.ssd
                    tvSd.text = it.sd
                    btnBuy.setOnClickListener {
                        Toast.makeText(context, "text", Toast.LENGTH_SHORT).show()
                    }

                    capacityFirst.text = "${it.capacity[0]} GB"
                    capacitySecond.text = "${it.capacity[1]} GB"*//*
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
        */
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}