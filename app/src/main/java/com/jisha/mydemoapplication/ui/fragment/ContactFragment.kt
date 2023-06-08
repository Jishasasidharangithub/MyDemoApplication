package com.jisha.mydemoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jisha.mydemoapplication.R
import com.jisha.mydemoapplication.databinding.FragmentContactBinding
import com.jisha.mydemoapplication.databinding.FragmentProfileBinding

class ContactFragment : Fragment() {

    private var binding: FragmentContactBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(
            LayoutInflater.from(requireContext()), container, false
        )
        return binding?.root
    }
}