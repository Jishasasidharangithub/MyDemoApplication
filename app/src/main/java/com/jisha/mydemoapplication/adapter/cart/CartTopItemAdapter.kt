package com.jisha.mydemoapplication.adapter.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jisha.mydemoapplication.databinding.ItemCartTopItemsBinding
import com.jisha.mydemoapplication.modelclass.cart.CartMainCategoryData
import com.jisha.mydemoapplication.modelclass.cart.CartTopCategoryItem

class CartTopItemAdapter () : RecyclerView.Adapter<CartTopItemAdapter.CartTopItemViewHolder>(){
    private val cartTopCategoryItems = mutableListOf<CartTopCategoryItem>()

    inner class CartTopItemViewHolder(val binding: ItemCartTopItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartTopItemViewHolder {
        return CartTopItemViewHolder(
            ItemCartTopItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }


    fun updateList(list: List<CartTopCategoryItem>) {
        cartTopCategoryItems.clear()
        cartTopCategoryItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cartTopCategoryItems.size
    }


    override fun onBindViewHolder(holder: CartTopItemViewHolder, position: Int) {
        with(cartTopCategoryItems[position]) {
            holder.binding.ivCartItem.setImageResource(image)
            holder.binding.tvTitle.text = title
            holder.binding.tvDescription.text = description
            holder.binding.tvOffer.text = offer
            holder.binding.tvPrice.text = price
            holder.binding.tvDiscount.text = discount
            holder.binding.tvCount.text = "$qty"

            holder.binding.ivMinus.isEnabled = qty != 0
            holder.binding.ivAdd.setOnClickListener {
                qty++
                holder.binding.tvCount.text = "$qty"
                holder.binding.ivMinus.isEnabled = true
            }
            holder.binding.ivMinus.setOnClickListener {
                if (qty > 0) {
                    qty--
                    holder.binding.tvCount.text = "$qty"
                }
                if (qty == 0) {
                    holder.binding.ivMinus.isEnabled = false
                }
            }

        }
       holder.binding.llDelete.setOnClickListener {
            cartTopCategoryItems.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartTopCategoryItems.size)
        }

    }

}