package com.jisha.mydemoapplication.adapter.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jisha.mydemoapplication.databinding.ItemCartMainRcvBinding
import com.jisha.mydemoapplication.modelclass.cart.CartMainCategoryData
import com.jisha.mydemoapplication.viewholder.CartViewHolder

class CartMainAdapter : ListAdapter<CartMainCategoryData, RecyclerView.ViewHolder>(DiffUtilCallback()) {

    companion object {
        const val VIEW_ONE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_ONE -> {
                val binding = ItemCartMainRcvBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                CartViewHolder.CartTopItemCategoryViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Unknown ViewType found in CartMainAdapter.kt")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = getItem(position)
        when (holder) {
            is CartViewHolder.CartTopItemCategoryViewHolder -> {
                holder.bind(data as CartMainCategoryData.CartTopItem)
            }
            else -> throw IllegalArgumentException("Unknown ViewHolder type found in CartMainAdapter.kt")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (val item = getItem(position)) {
            is CartMainCategoryData.CartTopItem -> VIEW_ONE
            else -> throw IllegalArgumentException("Unknown item type at position $position")
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<CartMainCategoryData>() {
        override fun areItemsTheSame(oldItem: CartMainCategoryData, newItem: CartMainCategoryData): Boolean {
            return when {
                oldItem is CartMainCategoryData.CartTopItem && newItem is CartMainCategoryData.CartTopItem -> {
                    oldItem.id == newItem.id
                }
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: CartMainCategoryData, newItem: CartMainCategoryData): Boolean {
            return when {
                oldItem is CartMainCategoryData.CartTopItem && newItem is CartMainCategoryData.CartTopItem -> {
                    oldItem == newItem
                }
                else -> false
            }
        }
    }
}
