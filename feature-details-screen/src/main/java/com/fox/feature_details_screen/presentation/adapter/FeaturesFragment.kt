package com.fox.feature_details_screen.presentation.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fox.feature_details_screen.databinding.FragmentFeaturesBinding

class FeaturesFragment : Fragment() {

    private lateinit var binding: FragmentFeaturesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeaturesBinding.inflate(inflater)
        return binding.root
    }
}