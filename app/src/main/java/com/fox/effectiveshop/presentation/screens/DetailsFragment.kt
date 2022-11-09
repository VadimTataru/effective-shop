package com.fox.effectiveshop.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.fox.effectiveshop.databinding.FragmentDetailsBinding
import com.fox.effectiveshop.presentation.adapter.ProductDetailsImagesRecyclerAdapter
import com.fox.effectiveshop.presentation.viewmodels.DetailsScreenViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

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
        initViews()
    }

    private fun initRecyclerView() {
        productDetailsImagesRecyclerAdapter = ProductDetailsImagesRecyclerAdapter()
        binding.imagesSpinner.apply {
            adapter = productDetailsImagesRecyclerAdapter
        }
    }

    private fun setImagesToRecyclerView() {
        viewModel.getProductDetails()
        viewModel.getImages().observe(viewLifecycleOwner) {
            if(it != null)
                productDetailsImagesRecyclerAdapter.setImages(it.toMutableList())
        }
    }

    private fun initViews() {
        viewModel.getDetailsInfo().observe(viewLifecycleOwner) {
            if(it != null) {
                binding.apply {
                    tvTitle.text = it.title
                    appCompatRatingBar.rating = it.rating
                    tvCore.text = it.cpu
                    tvCamera.text = it.camera
                    tvSsd.text = it.ssd
                    tvSd.text = it.sd
                }
            }
        }
    }
}