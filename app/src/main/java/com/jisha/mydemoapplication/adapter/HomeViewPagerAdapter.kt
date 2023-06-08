package com.jisha.mydemoapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jisha.mydemoapplication.databinding.ItemHomeViewpagerBinding
import com.jisha.mydemoapplication.modelclass.HomeViewPagerItem

class HomeViewPagerAdapter() :
    RecyclerView.Adapter<HomeViewPagerAdapter.HomeViewPagerViewHolder>() {

    private val homeViewPagerItems = mutableListOf<HomeViewPagerItem>()

    inner class HomeViewPagerViewHolder(val binding: ItemHomeViewpagerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewPagerViewHolder {
        return HomeViewPagerViewHolder(
            ItemHomeViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<HomeViewPagerItem>){
        homeViewPagerItems.clear()
        homeViewPagerItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return homeViewPagerItems.size
    }

    override fun onBindViewHolder(holder: HomeViewPagerViewHolder, position: Int) {
        with(homeViewPagerItems[position]) {
            holder.binding.ivProduct.setImageResource(image)
        }
    }
}
