package com.fox.feature_main_screen.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.fox.core_ui.utils.SpacingBestSellerDecorator
import com.fox.core_ui.utils.SpacingItemDecorator
import com.fox.feature_main_screen.R
import com.fox.feature_main_screen.databinding.FragmentMainScreenBinding
import com.fox.feature_main_screen.di.DaggerMainScreenComponent
import com.fox.feature_main_screen.di.MainScreenDeps
import com.fox.feature_main_screen.presentation.adapter.BestSellerRecyclerAdapter
import com.fox.feature_main_screen.presentation.adapter.CategoryRecyclerAdapter
import com.fox.feature_main_screen.presentation.adapter.HotSalesRecyclerAdapter
import com.fox.feature_main_screen.presentation.delegates.BestSellerDelegate
import com.fox.feature_main_screen.domain.models.Category
import com.fox.feature_main_screen.presentation.viewmodel.MainScreenViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainScreenFragment : Fragment() {
    private lateinit var binding: FragmentMainScreenBinding
    private var hotSalesRecyclerAdapter: HotSalesRecyclerAdapter? = null
    private var categoryRecyclerAdapter: CategoryRecyclerAdapter? = null
    private var bestSellerRecyclerAdapter: BestSellerRecyclerAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainScreenViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainScreenViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHotSalesRecyclerView()
        initBestSellerRecyclerView(view)
        initCategoryRecyclerView()
        setDataToAdapters()
    }

    override fun onDestroy() {
        super.onDestroy()
        Glide.get(requireContext()).clearDiskCache()
        Glide.get(requireContext()).clearMemory()
    }

    private fun initHotSalesRecyclerView() {
        hotSalesRecyclerAdapter = HotSalesRecyclerAdapter()
        binding.hotSalesViewPager.apply {
            adapter = hotSalesRecyclerAdapter
        }
    }

    private fun initCategoryRecyclerView() {
        categoryRecyclerAdapter = CategoryRecyclerAdapter()
        categoryRecyclerAdapter?.setCategories(mockCategories())
        val itemDecoration = SpacingItemDecorator(60)
        binding.rvCategories.apply {
            addItemDecoration(itemDecoration)
            adapter = categoryRecyclerAdapter
        }
    }

    private fun initBestSellerRecyclerView(view: View) {
        bestSellerRecyclerAdapter = BestSellerRecyclerAdapter(object : BestSellerDelegate {
            override fun onBestSellerViewClick() {
                //navigate
            }

        })
        val itemDecorator = SpacingBestSellerDecorator(20)
        binding.rvBestSeller.apply {
            addItemDecoration(itemDecorator)
            adapter = bestSellerRecyclerAdapter
        }
    }

    private fun setDataToAdapters() {
        viewModel.getPhonesData()
        viewModel.getHotSales().observe(viewLifecycleOwner) {
            if(it != null)
                hotSalesRecyclerAdapter?.setHotSaleList(it.toMutableList())
            else
                Toast.makeText(this@MainScreenFragment.requireContext(), "Error in data loading", Toast.LENGTH_SHORT).show()
        }
        viewModel.getBestSellers().observe(viewLifecycleOwner) {
            if(it != null)
                bestSellerRecyclerAdapter?.setBestSellerList(it.toMutableList())
            else
                Toast.makeText(this@MainScreenFragment.requireContext(), "Error in data loading", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mockCategories(): MutableList<Category> {
        return mutableListOf(
            Category(
                "Phone",
                R.drawable.ic_phone_white,
                R.drawable.ic_phone_orange,
                true
            ),
            Category(
                "Computer",
                R.drawable.ic_computer_white,
                R.drawable.ic_computer_orange,
                false
            ),
            Category(
                "Health",
                R.drawable.ic_health_white,
                R.drawable.ic_health_orange,
                false
            ),
            Category(
                "Books",
                R.drawable.ic_books_white,
                R.drawable.ic_books_orange,
                false
            ),
            Category(
                "Other",
                R.drawable.ic_computer_white,
                R.drawable.ic_computer_orange,
                false
            ),
        )
    }
}