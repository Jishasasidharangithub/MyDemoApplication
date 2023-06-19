package com.jisha.mydemoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jisha.mydemoapplication.R
import com.jisha.mydemoapplication.databinding.FragmentScreenOneBinding
import com.jisha.mydemoapplication.databinding.FragmentScreenThreeBinding
import com.jisha.mydemoapplication.databinding.FragmentScreenTwoBinding

class ScreenThreeFragment : Fragment() {
    private var binding: FragmentScreenThreeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentScreenThreeBinding.inflate(layoutInflater)
        return binding?.root
    }
}