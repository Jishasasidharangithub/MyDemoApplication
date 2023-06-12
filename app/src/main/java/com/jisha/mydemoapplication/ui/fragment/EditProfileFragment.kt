package com.jisha.mydemoapplication.ui.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.github.dhaval2404.imagepicker.ImagePicker
import com.jisha.mydemoapplication.R
import com.jisha.mydemoapplication.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {

    private var binding: FragmentEditProfileBinding? = null
    private val IMAGE_REQUEST_CODE = 13
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(
            LayoutInflater.from(requireContext()), container, false
        )
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize SharedPreferences
        sharedPreferences = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        init()
        handleEvents()
        loadSavedData()
    }
    private fun loadSavedData() {
        val savedName = sharedPreferences.getString("name", "")
        val savedEmail = sharedPreferences.getString("email", "")
        val imagePath = sharedPreferences.getString("imagePath","")


        // Populate the EditText fields with the saved values
        binding?.etFullName?.setText(savedName)
        binding?.etEmail?.setText(savedEmail)
        binding?.ivUser?.setImageURI(imagePath?.toUri())
    }

    private fun saveDataToSharedPreferences() {
        val name = binding?.etFullName?.text.toString()
        val email = binding?.etEmail?.text.toString()




        // Save the values to SharedPreferences
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("email", email)
        editor.apply()
    }

    private fun navigateToProfileFragment() {
        // Replace the current fragment with the ProfileFragment
        val profileFragment = ProfileFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, profileFragment)
            .commit()
    }
    private fun init() {
        binding?.editProfiletoolbar?.tvTitle?.text = "Edit Profile"
    }
    private fun handleEvents(){
        binding?.ivUser?.setOnClickListener {
            imagePicker()
        }
        binding?.btnSave?.setOnClickListener {
            saveDataToSharedPreferences()
            navigateToProfileFragment()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val uri: Uri? = data?.data
            uri?.let {
                binding?.ivUser?.setImageURI(it)
                val editor = sharedPreferences.edit()
                editor.putString("imagePath",it.toString())
                editor.apply()
            }

            Toast.makeText(requireContext(),"Image Uploaded",Toast.LENGTH_LONG).show()
        }
    }

    private fun imagePicker() {
        ImagePicker.with(this).crop() //Crop image(Optional), Check Customization for more option
            .start(IMAGE_REQUEST_CODE)

    }

}