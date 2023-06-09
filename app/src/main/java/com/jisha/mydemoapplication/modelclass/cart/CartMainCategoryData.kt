package com.jisha.mydemoapplication.modelclass.cart

sealed class CartMainCategoryData {
    class CartTopItem(
        val id:Int,
        val cartTopCategoryList: List<CartTopCategoryItem>
    ): CartMainCategoryData()
    class CartSubItem(
        val id:Int,
        val title: String,
        val productList:List<CartSubCategoryItem>
    ): CartMainCategoryData()

}