package com.fox.effectiveshop.presentation.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.fox.effectiveshop.R
import com.fox.effectiveshop.databinding.FragmentDetailsBinding
import com.fox.effectiveshop.presentation.adapter.ProductDetailsImagesRecyclerAdapter
import com.fox.effectiveshop.presentation.viewmodels.DetailsScreenViewModel
import com.fox.effectiveshop.presentation.viewmodels.MainScreenViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import kotlin.math.abs

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: DetailsScreenViewModel

    private lateinit var productDetailsImagesRecyclerAdapter: ProductDetailsImagesRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailsScreenViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setImagesToRecyclerView()
    }

    private fun initRecyclerView() {
        productDetailsImagesRecyclerAdapter = ProductDetailsImagesRecyclerAdapter()
        binding.imagesSpinner.apply {
            adapter = productDetailsImagesRecyclerAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3

            /*val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer(40))
            compositePageTransformer.addTransformer{page, position ->
                val r: Float = 1 - abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }
            setPageTransformer(compositePageTransformer)*/
        }
    }

    private fun setImagesToRecyclerView() {
        viewModel.getProductDetails()
        viewModel.getImages().observe(viewLifecycleOwner) {
            if(it != null)
                productDetailsImagesRecyclerAdapter.setImages(it.toMutableList())
        }
    }
}