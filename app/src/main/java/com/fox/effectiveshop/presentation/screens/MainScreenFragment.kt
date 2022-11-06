package com.fox.effectiveshop.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fox.effectiveshop.R
import com.fox.effectiveshop.databinding.FragmentMainScreenBinding
import com.fox.effectiveshop.presentation.adapter.BestSellerRecyclerAdapter
import com.fox.effectiveshop.presentation.adapter.CategoryRecyclerAdapter
import com.fox.effectiveshop.presentation.adapter.HotSalesRecyclerAdapter
import com.fox.effectiveshop.presentation.models.Category
import com.fox.effectiveshop.presentation.utils.SpacingItemDecorator
import com.fox.effectiveshop.presentation.viewmodels.MainScreenViewModel
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
        initBestSellerRecyclerView()
        initCategoryRecyclerView()
        setDataToAdapters()
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

    private fun initBestSellerRecyclerView() {
        bestSellerRecyclerAdapter = BestSellerRecyclerAdapter()
        binding.rvBestSeller.apply {
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
                R.drawable.white_ellipse,
                R.drawable.ellipse,
                false
            ),
        )
    }
}