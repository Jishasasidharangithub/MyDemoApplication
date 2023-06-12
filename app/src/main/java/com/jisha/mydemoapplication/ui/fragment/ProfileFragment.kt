package com.jisha.mydemoapplication.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import com.jisha.mydemoapplication.R
import com.jisha.mydemoapplication.databinding.FragmentProfileBinding
import com.jisha.mydemoapplication.databinding.FragmentSearchBinding

class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding? = null
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(
            LayoutInflater.from(requireContext()), container, false
        )
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        handleEvents()
        loadSavedData()
    }
    private fun loadSavedData() {
        val savedName = sharedPreferences.getString("name", "")
        val savedEmail = sharedPreferences.getString("email", "")
        val imagePath = sharedPreferences.getString("imagePath","")

        // Display the saved values in the TextViews
        binding?.profileToolbar?.tvUserName?.text = savedName
        binding?.profileToolbar?.tvEmail?.text= savedEmail
        binding?.profileToolbar?.ivUser?.setImageURI(imagePath?.toUri())
    }
    fun handleEvents() {
        binding?.profileToolbar?.tvEdit?.setOnClickListener {
            findNavController().navigate(R.id.editProfileFragment)
        }
    }
}