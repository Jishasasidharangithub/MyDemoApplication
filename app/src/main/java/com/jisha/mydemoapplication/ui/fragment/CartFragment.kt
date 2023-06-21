package com.jisha.mydemoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.jisha.mydemoapplication.R
import com.jisha.mydemoapplication.adapter.cart.ScreenMovingAdapter
import com.jisha.mydemoapplication.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private var binding: FragmentCartBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCartBinding.inflate(
            LayoutInflater.from(requireContext()), container, false
        )
        return binding?.root
    }

    val fragmentList = arrayListOf<Fragment>(
        ScreenOneFragment(),
        ScreenTwoFragment(),
        ScreenThreeFragment(),
        ScreenFourFragment()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ScreenMovingAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding?.viewPager?.adapter = adapter

        init()
        initButtonBackgrounds()
    }
    private fun initButtonBackgrounds() {
        val buttons = arrayOf(
            binding?.carttoolbar?.appCompatButton1,
            binding?.carttoolbar?.appCompatButton2,
            binding?.carttoolbar?.appCompatButton3,
            binding?.carttoolbar?.appCompatButton4
        )

        binding?.viewPager?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                for (i in buttons.indices) {
                    val button = buttons[i]
                    button?.isSelected = (i == position)
                    button?.setBackgroundResource(if (i == position) R.drawable.selected_btn_bg_color else R.drawable.unselected_btn_bg_color)
                }
            }
        })
    }

    private fun init() {
        binding?.carttoolbar?.tvTitle?.text = "Cart"
    }

}