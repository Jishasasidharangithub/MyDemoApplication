package com.jisha.mydemoapplication.adapter.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jisha.mydemoapplication.databinding.ItemCartMainRcv1Binding
import com.jisha.mydemoapplication.databinding.ItemCartMainRcvBinding
import com.jisha.mydemoapplication.modelclass.cart.CartMainCategoryData
import com.jisha.mydemoapplication.viewholder.CartViewHolder

class CartMainAdapter : ListAdapter<CartMainCategoryData, RecyclerView.ViewHolder>(DiffUtilCallback()) {

    companion object {
        const val VIEW_ONE = 1
        const val VIEW_TWO = 2
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
            VIEW_TWO -> {
                val binding = ItemCartMainRcv1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                CartViewHolder.CartSubCategoryViewHolder(binding)
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
            is CartViewHolder.CartSubCategoryViewHolder -> {
                holder.bind(data as CartMainCategoryData.CartSubItem)
            }
            else -> throw IllegalArgumentException("Unknown ViewHolder type found in CartMainAdapter.kt")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (val item = getItem(position)) {
            is CartMainCategoryData.CartTopItem -> VIEW_ONE
            is CartMainCategoryData.CartSubItem -> VIEW_TWO
            else -> throw IllegalArgumentException("Unknown item type at position $position")
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<CartMainCategoryData>() {
        override fun areItemsTheSame(oldItem: CartMainCategoryData, newItem: CartMainCategoryData): Boolean {
            return when {
                oldItem is CartMainCategoryData.CartTopItem && newItem is CartMainCategoryData.CartTopItem -> {
                    oldItem.id == newItem.id
                }
                oldItem is CartMainCategoryData.CartSubItem && newItem is CartMainCategoryData.CartSubItem -> {
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
                oldItem is CartMainCategoryData.CartSubItem && newItem is CartMainCategoryData.CartSubItem -> {
                    oldItem == newItem
                }
                else -> false
            }
        }
    }
}
