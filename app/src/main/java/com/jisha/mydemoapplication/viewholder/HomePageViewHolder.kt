package com.jisha.mydemoapplication.viewholder

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.jisha.mydemoapplication.R
import com.jisha.mydemoapplication.adapter.HomeViewPagerAdapter
import com.jisha.mydemoapplication.adapter.ShopByCategoryAdapter
import com.jisha.mydemoapplication.databinding.ItemHomeMainRcvBinding
import com.jisha.mydemoapplication.databinding.LayoutHomeViewpagerBinding
import com.jisha.mydemoapplication.modelclass.HomeMainCategoryData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class HomePageViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class HomeBannerCategoryViewHolder(val binding: LayoutHomeViewpagerBinding) :
        HomePageViewHolder(binding) {
        fun bind(
            item: HomeMainCategoryData.HomeBannerCategory,
            viewLifecycleOwner: LifecycleOwner
        ) {
            val homebannerViewPager = HomeViewPagerAdapter()
            binding.vpBanner.apply {
                adapter = homebannerViewPager

                viewLifecycleOwner.lifecycleScope.launch {
                    autoScroll(4000)
                }

                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        val bannerSize = item.homeviewpagerList.size
                        binding.llSlideIndicator.removeAllViews()


                        val slidingImageDotsBanner =
                            List(bannerSize) { ImageView(binding.root.context) }
                        slidingImageDotsBanner.forEach {
                            it.load(R.drawable.inactive_dot_clearbg)
                            binding.llSlideIndicator.addView(it)
                        }
                        slidingImageDotsBanner.getOrNull(0)?.load(R.drawable.active_dot_banner)
                        slidingImageDotsBanner.forEachIndexed { index, imageView ->
                            imageView.load(if (index == position) R.drawable.active_dot_banner else R.drawable.inactive_dot_clearbg)
                        }
                    }
                })
            }
            homebannerViewPager.updateList(item.homeviewpagerList)
        }

        private suspend fun ViewPager2.autoScroll(interval: Long) {
            try {
                while (true) {
                    delay(interval)
                    val numberOfItems = adapter?.itemCount ?: 0
                    if (numberOfItems > 0) {
                        val nextItem = (currentItem + 1) % numberOfItems
                        setCurrentItem(nextItem, true)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    class HomeShopByCategoryViewHolder(private val binding: ItemHomeMainRcvBinding) :
        HomePageViewHolder(binding) {
        fun bind(item: HomeMainCategoryData.HomeShopByCategory) {
            binding.tvTitle.text = item.title
            val a = ShopByCategoryAdapter()
            binding.rvShopByCategory.apply {
                adapter = a
                    layoutManager = GridLayoutManager(binding.root.context, 3,LinearLayoutManager.HORIZONTAL,false)
            }
            a.updateList(item.homeShopByCategoryList)
        }
    }

}

