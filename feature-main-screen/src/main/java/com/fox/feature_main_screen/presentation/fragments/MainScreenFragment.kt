package com.fox.feature_main_screen.presentation.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.fox.core_ui.navigation.DeepLinks.PRODUCT_DETAILS_SCREEN
import com.fox.core_ui.utils.SpacingItemDecorator
import com.fox.core_ui.utils.SpacingType
import com.fox.feature_main_screen.R
import com.fox.feature_main_screen.databinding.FragmentMainScreenBinding
import com.fox.feature_main_screen.presentation.adapter.BestSellerRecyclerAdapter
import com.fox.feature_main_screen.presentation.adapter.CategoryRecyclerAdapter
import com.fox.feature_main_screen.presentation.adapter.HotSalesRecyclerAdapter
import com.fox.feature_main_screen.presentation.delegates.OnProductClickDelegate
import com.fox.feature_main_screen.domain.models.Category
import com.fox.feature_main_screen.presentation.viewmodel.MainScreenViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
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
        initBottomNavigationBar()
        initHotSalesRecyclerView()
        initBestSellerRecyclerView()
        initCategoryRecyclerView()
        initBottomSheetController()
        setDataToAdapters()
    }

    override fun onDestroy() {
        super.onDestroy()
        Glide.get(requireContext()).clearDiskCache()
        Glide.get(requireContext()).clearMemory()
    }

    private fun initBottomNavigationBar() {

    }

    private fun initHotSalesRecyclerView() {
        hotSalesRecyclerAdapter = HotSalesRecyclerAdapter(object : OnProductClickDelegate {
            override fun onProductViewClick() {
                findNavController().navigate(Uri.parse(getString(PRODUCT_DETAILS_SCREEN)))
            }
        })
        binding.hotSalesViewPager.apply {
            adapter = hotSalesRecyclerAdapter
        }
    }

    private fun initCategoryRecyclerView() {
        categoryRecyclerAdapter = CategoryRecyclerAdapter()
        categoryRecyclerAdapter?.setCategories(mockCategories())
        val itemDecoration = SpacingItemDecorator(60, SpacingType.Left)
        binding.rvCategories.apply {
            addItemDecoration(itemDecoration)
            adapter = categoryRecyclerAdapter
        }
    }

    private fun initBestSellerRecyclerView() {
        bestSellerRecyclerAdapter = BestSellerRecyclerAdapter(object : OnProductClickDelegate {
            override fun onProductViewClick() {
                findNavController().navigate(Uri.parse(getString(PRODUCT_DETAILS_SCREEN)))
            }

        })
        val itemDecorator = SpacingItemDecorator(20, SpacingType.All)
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

    private fun initBottomSheetController() {
        binding.apply {
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetContainer)
            filter.setOnClickListener {
                if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetContainer.visibility = View.INVISIBLE
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                } else {
                    bottomSheetContainer.visibility = View.VISIBLE
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            }
            filterBottomSheet.btnClose.setOnClickListener {
                bottomSheetContainer.visibility = View.INVISIBLE
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
            filterBottomSheet.btnDone.setOnClickListener {
                bottomSheetContainer.visibility = View.INVISIBLE
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }
}