package com.jisha.mydemoapplication.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jisha.mydemoapplication.databinding.ItemShopByCategoryBinding
import com.jisha.mydemoapplication.modelclass.home.ShopByCategoryItem

class ShopByCategoryAdapter () : RecyclerView.Adapter<ShopByCategoryAdapter.HomeShopByCategoryViewHolder>()  {

    private val homeCategoryByItems = mutableListOf<ShopByCategoryItem>()

    inner class HomeShopByCategoryViewHolder(val binding: ItemShopByCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeShopByCategoryViewHolder {
        return HomeShopByCategoryViewHolder(
            ItemShopByCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<ShopByCategoryItem>) {
        homeCategoryByItems.clear()
        homeCategoryByItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return homeCategoryByItems.size
    }

    override fun onBindViewHolder(holder: HomeShopByCategoryViewHolder, position: Int) {
        with(homeCategoryByItems[position]) {
            holder.binding.ivCartItem.setImageResource(image)
            holder.binding.tvCartItemTitle.text = title
        }
    }
}