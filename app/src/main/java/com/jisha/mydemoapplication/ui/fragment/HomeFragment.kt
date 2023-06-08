package com.jisha.mydemoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jisha.mydemoapplication.R
import com.jisha.mydemoapplication.adapter.HomeMainAdapter
import com.jisha.mydemoapplication.databinding.FragmentHomeBinding
import com.jisha.mydemoapplication.modelclass.HomeMainCategoryData
import com.jisha.mydemoapplication.modelclass.HomeViewPagerItem
import com.jisha.mydemoapplication.modelclass.ShopByCategoryItem

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private val homemainAdapter: HomeMainAdapter by lazy { HomeMainAdapter(viewLifecycleOwner) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(
            LayoutInflater.from(requireContext()), container, false
        )
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initView()
    }


    private fun init() {
        binding?.homeToolbar?.tvHomeTitle?.text = "Home Page"
    }

    private fun initView() {
        binding?.rvHomeSet?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = homemainAdapter
            categoryListData()
        }
    }

    private fun categoryListData() {
        val subList = listOf(
            HomeViewPagerItem(R.drawable.viewpagerimage),
            HomeViewPagerItem(R.drawable.viewpagerimage),
            HomeViewPagerItem(R.drawable.viewpagerimage)
        )
        val subList1 = listOf(
            ShopByCategoryItem(
                R.drawable.shop_by_item,
                "Baby Needs"
            ), ShopByCategoryItem(
                R.drawable.shop_by_item,
                "Baby Needs"
            ), ShopByCategoryItem(
                R.drawable.shop_by_item,
                "Baby Needs"
            ), ShopByCategoryItem(
                R.drawable.shop_by_item,
                "Baby Needs"
            ), ShopByCategoryItem(
                R.drawable.shop_by_item,
                "Baby Needs"
            ), ShopByCategoryItem(
                R.drawable.shop_by_item,
                "Baby Needs"
            ), ShopByCategoryItem(
                R.drawable.shop_by_item,
                "Baby Needs"
            ), ShopByCategoryItem(
                R.drawable.shop_by_item,
                "Baby Needs"
            ), ShopByCategoryItem(
                R.drawable.shop_by_item,
                "Baby Needs"
            )
        )
        val mainList = listOf(
            HomeMainCategoryData.HomeBannerCategory(1, subList),
            HomeMainCategoryData.HomeShopByCategory(2, "Shop By Category",subList1)
        )
        homemainAdapter.submitList(mainList)
    }
}