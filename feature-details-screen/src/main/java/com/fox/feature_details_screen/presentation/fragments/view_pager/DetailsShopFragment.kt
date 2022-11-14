package com.fox.feature_details_screen.presentation.fragments.view_pager

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fox.core_ui.navigation.DeepLinks
import com.fox.core_ui.presentation.BaseFragment
import com.fox.feature_details_screen.R
import com.fox.feature_details_screen.databinding.FragmentDetailsShopBinding
import com.fox.feature_details_screen.presentation.viewmodel.DetailsScreenViewModel

class DetailsShopFragment : BaseFragment() {

    private lateinit var binding: FragmentDetailsShopBinding
    private lateinit var sharedViewModel: DetailsScreenViewModel

    private var isFirstColor: Boolean = true
    private var isSecondColor: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsShopBinding.inflate(inflater)

        sharedViewModel = ViewModelProvider(requireParentFragment())[DetailsScreenViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        sharedViewModel.observeViewPagerShopInfo().observe(viewLifecycleOwner) {
            if(it != null) {
                binding.apply {
                    tvCore.text = it.cpu
                    tvCamera.text = it.camera
                    tvSsd.text = it.ssd
                    tvSd.text = it.sd
                    btnBuy.setOnClickListener {
                        navigateTo(getString(DeepLinks.CART_SCREEN))
                    }

                    capacityFirst.text = "${it.capacity[0]} GB"
                    capacitySecond.text = "${it.capacity[1]} GB"
                    colorFirst.background.setCardBackgroundColor(Color.parseColor(it.color[0]))
                    colorSecond.background.setCardBackgroundColor(Color.parseColor(it.color[1]))

                    colorSecond.background.setOnClickListener { _ ->
                        sharedViewModel.pickColor(Color.parseColor(it.color[1]))
                    }
                    colorFirst.background.setOnClickListener { _ ->
                        sharedViewModel.pickColor(Color.parseColor(it.color[0]))
                        sharedViewModel.observePickedColor().observe(viewLifecycleOwner) { pickedColor ->
                            when(pickedColor) {
                                Color.parseColor(it.color[0]) -> {
                                    colorFirst.checkmark.setImageResource(com.fox.core_ui.R.drawable.ic_round_check_24)
                                    colorSecond.checkmark.setImageResource(0)
                                }
                                Color.parseColor(it.color[1]) -> {
                                    colorSecond.checkmark.setImageResource(com.fox.core_ui.R.drawable.ic_round_check_24)
                                    colorFirst.checkmark.setImageResource(0)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}