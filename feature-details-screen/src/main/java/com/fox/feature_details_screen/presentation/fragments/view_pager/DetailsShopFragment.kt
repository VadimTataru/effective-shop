package com.fox.feature_details_screen.presentation.fragments.view_pager

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
import com.fox.feature_details_screen.databinding.FragmentDetailsShopBinding
import com.fox.feature_details_screen.presentation.viewmodel.DetailsScreenViewModel

class DetailsShopFragment : BaseFragment() {

    private lateinit var binding: FragmentDetailsShopBinding
    private lateinit var sharedViewModel: DetailsScreenViewModel

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
        sharedViewModel.getViewPagerShopInfo().observe(viewLifecycleOwner) {
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
                }
            }
        }
    }
}