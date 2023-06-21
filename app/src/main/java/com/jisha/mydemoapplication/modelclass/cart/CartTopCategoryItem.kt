package com.jisha.mydemoapplication.modelclass.cart

data class CartTopCategoryItem (
    val image : Int,
    val title : String,
    val description : String,
    val offer : String,
    val price : String,
    val discount : String,
    var qty : Int
        )