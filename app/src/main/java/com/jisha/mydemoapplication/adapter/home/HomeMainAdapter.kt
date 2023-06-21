package com.jisha.mydemoapplication.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jisha.mydemoapplication.databinding.ItemHomeMainRcvBinding
import com.jisha.mydemoapplication.databinding.LayoutHomeViewpagerBinding
import com.jisha.mydemoapplication.modelclass.home.HomeMainCategoryData
import com.jisha.mydemoapplication.viewholder.HomePageViewHolder

class HomeMainAdapter(private val viewLifecycleOwner: LifecycleOwner) : ListAdapter<HomeMainCategoryData, HomePageViewHolder>(
    DiffUtilCallback()
)  {

    companion object {
        const val VIEW_ONE = 1
        const val VIEW_TWO = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageViewHolder {
        return when (viewType) {
            VIEW_ONE -> {
                HomePageViewHolder.HomeBannerCategoryViewHolder(
                    LayoutHomeViewpagerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            VIEW_TWO -> {
                HomePageViewHolder.HomeShopByCategoryViewHolder(
                    ItemHomeMainRcvBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> throw java.lang.Exception("Unknown ViewType Found!  in MainCategoryAdapter.kt")
        }
    }

    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        val data = getItem(position)
        when (holder) {
            is HomePageViewHolder.HomeBannerCategoryViewHolder -> holder.bind(data as HomeMainCategoryData.HomeBannerCategory,viewLifecycleOwner)
            is HomePageViewHolder.HomeShopByCategoryViewHolder -> holder.bind(data as HomeMainCategoryData.HomeShopByCategory)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HomeMainCategoryData.HomeBannerCategory -> VIEW_ONE
            is HomeMainCategoryData.HomeShopByCategory -> VIEW_TWO
            else -> throw java.lang.Exception("Unknown Get item position!!")
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<HomeMainCategoryData>() {
        override fun areItemsTheSame(
            oldItem: HomeMainCategoryData,
            newItem: HomeMainCategoryData
        ): Boolean {
            return when {
                oldItem is HomeMainCategoryData.HomeBannerCategory && newItem is HomeMainCategoryData.HomeBannerCategory -> {
                    oldItem.id == newItem.id
                }
                oldItem is HomeMainCategoryData.HomeShopByCategory && newItem is HomeMainCategoryData.HomeShopByCategory -> {
                    oldItem.id == newItem.id
                }
                else -> false
            }
        }

        override fun areContentsTheSame(
            oldItem: HomeMainCategoryData,
            newItem: HomeMainCategoryData
        ): Boolean {
            return when {
                oldItem is HomeMainCategoryData.HomeBannerCategory && newItem is HomeMainCategoryData.HomeBannerCategory -> {
                    oldItem == newItem
                }
                oldItem is HomeMainCategoryData.HomeShopByCategory && newItem is HomeMainCategoryData.HomeShopByCategory -> {
                    oldItem == newItem
                }
                else -> false
            }
        }


    }

}