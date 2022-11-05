package com.fox.effectiveshop.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fox.effectiveshop.R
import com.fox.effectiveshop.databinding.FragmentMainScreenBinding
import com.fox.effectiveshop.presentation.adapter.HotSalesRecyclerAdapter

class MainScreenFragment : Fragment() {
    private lateinit var binding: FragmentMainScreenBinding
    private var hotSalesRecyclerAdapter: HotSalesRecyclerAdapter? = null
    private val images: IntArray = intArrayOf(
        R.drawable.ellipse,
        R.drawable.mock_best_seller,
        R.drawable.test,
        R.drawable.sakura
    )

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

    }
}