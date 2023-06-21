package com.jisha.mydemoapplication.viewholder

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.jisha.mydemoapplication.adapter.cart.CartMainAdapter
import com.jisha.mydemoapplication.adapter.cart.CartSubItemAdapter
import com.jisha.mydemoapplication.adapter.cart.CartTopItemAdapter
import com.jisha.mydemoapplication.databinding.ItemCartMainRcv1Binding
import com.jisha.mydemoapplication.databinding.ItemCartMainRcvBinding
import com.jisha.mydemoapplication.modelclass.cart.CartMainCategoryData
import com.jisha.mydemoapplication.modelclass.cart.CartTopCategoryItem

open class CartViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class CartTopItemCategoryViewHolder(private val binding: ItemCartMainRcvBinding) :
        HomePageViewHolder(binding) {

        fun bind(item: CartMainCategoryData.CartTopItem) {

            val a = CartTopItemAdapter()
            binding.rvCartTopItems.apply {
                adapter = a
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
            a.updateList(item.cartTopCategoryList)

        }
    }
    class CartSubCategoryViewHolder(val binding: ItemCartMainRcv1Binding) :
        HomePageViewHolder(binding) {
        fun bind(item: CartMainCategoryData.CartSubItem) {
            binding.tvTitle.text = item.title
            val a = CartSubItemAdapter {

            }
            binding.recyclerView.apply {
                adapter = a
                layoutManager = GridLayoutManager(binding.root.context, 2)
            }
            a.updateList(item.productList)
        }
    }
}