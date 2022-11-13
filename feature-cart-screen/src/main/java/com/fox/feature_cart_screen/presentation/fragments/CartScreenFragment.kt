package com.fox.feature_cart_screen.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fox.feature_cart_screen.R
import com.fox.feature_cart_screen.databinding.FragmentCartScreenBinding

class CartScreenFragment : Fragment() {
    lateinit var binding: FragmentCartScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartScreenBinding.inflate(inflater)
        return binding.root
    }
}