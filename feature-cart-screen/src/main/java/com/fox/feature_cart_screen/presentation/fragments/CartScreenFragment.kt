package com.fox.feature_cart_screen.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.fox.core_ui.utils.SpacingItemDecorator
import com.fox.core_ui.utils.SpacingType
import com.fox.feature_cart_screen.R
import com.fox.feature_cart_screen.databinding.FragmentCartScreenBinding
import com.fox.feature_cart_screen.presentation.adapter.BasketRecyclerAdapter
import com.fox.feature_cart_screen.presentation.delegates.BasketItemDelegate
import com.fox.feature_cart_screen.presentation.viewmodel.CartScreenViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CartScreenFragment : Fragment() {
    lateinit var binding: FragmentCartScreenBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CartScreenViewModel

    private var basketRecyclerAdapter: BasketRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[CartScreenViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()
        initAdapters()
        initViews()
    }

    private fun initViews() {
        viewModel.getCartProductInfo().observe(viewLifecycleOwner) {
            binding.apply {
                tvDelivery.text = it.delivery
                tvTotal.text = it.total.toString()
            }
        }
    }

    private fun initAdapters() {
        basketRecyclerAdapter = BasketRecyclerAdapter(object: BasketItemDelegate{
            override fun onClickMinus() {
                TODO("Not yet implemented")
            }

            override fun onClickPlus() {
                TODO("Not yet implemented")
            }

            override fun onClickTrash(id: Int) {
                viewModel.deleteProduct(id)
            }

        })
        val itemDecorator = SpacingItemDecorator(10, SpacingType.Vertical)

        binding.recyclerView.apply {
            addItemDecoration(itemDecorator)
            adapter = basketRecyclerAdapter
        }
    }
}