package com.fox.effectiveshop.presentation.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.fox.effectiveshop.R
import com.fox.effectiveshop.databinding.FragmentMainScreenBinding
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

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainScreenViewModel


    private val images: IntArray = intArrayOf(
        R.drawable.ellipse,
        R.drawable.mock_best_seller,
        R.drawable.test,
        R.drawable.sakura
    )

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
        hotSalesRecyclerAdapter = HotSalesRecyclerAdapter(images)
        binding.hotSalesViewPager.apply {
            adapter = hotSalesRecyclerAdapter
        }
        initCategoryRecyclerView()
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