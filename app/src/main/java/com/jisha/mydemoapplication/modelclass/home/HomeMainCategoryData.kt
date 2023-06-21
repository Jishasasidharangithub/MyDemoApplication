package com.jisha.mydemoapplication.modelclass.home

sealed class HomeMainCategoryData {
    class HomeBannerCategory(
        val id:Int,
        val homeviewpagerList: List<HomeViewPagerItem>
    ): HomeMainCategoryData()

    class HomeShopByCategory(
        val id:Int,
        val title:String,
        val homeShopByCategoryList: List<ShopByCategoryItem>
    ): HomeMainCategoryData()
}