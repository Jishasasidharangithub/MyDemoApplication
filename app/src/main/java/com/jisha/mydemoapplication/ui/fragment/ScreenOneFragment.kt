package com.jisha.mydemoapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jisha.mydemoapplication.R
import com.jisha.mydemoapplication.adapter.cart.CartMainAdapter
import com.jisha.mydemoapplication.databinding.FragmentScreenOneBinding
import com.jisha.mydemoapplication.modelclass.cart.CartMainCategoryData
import com.jisha.mydemoapplication.modelclass.cart.CartTopCategoryItem


class ScreenOneFragment : Fragment() {
    private var binding: FragmentScreenOneBinding? = null
    private val cartMainAdapter: CartMainAdapter by lazy { CartMainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScreenOneBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding?.rvScreenOne?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cartMainAdapter
        }
        cartTopItemListData()
    }

    private fun cartTopItemListData() {
        val subList = listOf(
            CartTopCategoryItem(
                R.drawable.watch,
                "Watch",
                "Watch",
                "20% off",
                "Rs. 2000",
                "Rs. 1500",
                0
            ),
            CartTopCategoryItem(
                R.drawable.watch,
                "Watch",
                "Watch",
                "20% off",
                "Rs. 2000",
                "Rs. 1500",
                0
            )
        )
        val mainList = listOf(
            CartMainCategoryData.CartTopItem(1, subList),
        )
        cartMainAdapter.submitList(mainList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
