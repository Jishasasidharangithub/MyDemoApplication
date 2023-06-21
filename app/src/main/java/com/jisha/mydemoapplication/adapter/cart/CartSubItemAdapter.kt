package com.jisha.mydemoapplication.adapter.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jisha.mydemoapplication.databinding.ItemSubCartItemBinding
import com.jisha.mydemoapplication.modelclass.cart.CartSubCategoryItem

class CartSubItemAdapter(private val itemClick: (position:Int) -> Unit) :
    RecyclerView.Adapter<CartSubItemAdapter.CartSubCategoryViewHolder>() {

    private val products = mutableListOf<CartSubCategoryItem>()

    inner class CartSubCategoryViewHolder(val binding: ItemSubCartItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartSubCategoryViewHolder {
        return CartSubCategoryViewHolder(
            ItemSubCartItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun updateList(list: List<CartSubCategoryItem>) {
        products.clear()
        products.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: CartSubCategoryViewHolder, position: Int) {
        with(products[position]) {
            holder.binding.tvAED.text = aed
            holder.binding.ivCardiacCare.setImageResource(image)
            holder.binding.tvCardiacCareDescription.text = description
            holder.binding.root.setOnClickListener {
                itemClick.invoke(holder.bindingAdapterPosition)
            }
        }
    }
}