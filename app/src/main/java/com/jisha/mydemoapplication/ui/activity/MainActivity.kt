package com.jisha.mydemoapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.jisha.mydemoapplication.R
import com.jisha.mydemoapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var navController: NavController? = null
    private var navHostFragment: NavHostFragment? = null
    private var graph: NavGraph? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        init()
        handleEvents()
    }
    private fun init() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val inflater = navHostFragment?.navController?.navInflater
        graph = inflater?.inflate(R.navigation.my_nav)
        setDestination()
    }

    private fun setDestination() {
        graph?.setStartDestination(R.id.homeFragment)
        navController = navHostFragment?.navController
        graph?.let { navController?.setGraph(it, intent.extras) }
    }

    private fun handleEvents() {
        binding?.bottomNav?.setOnItemSelectedListener {
            if (navController?.currentDestination?.id != it.itemId)
                navController?.navigate(it.itemId)
            false
        }

        navController?.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.profileFragment , R.id.searchFragment, R.id.contactFragment,R.id.cartFragment -> {
                    binding?.bottomNav?.menu?.findItem(destination.id)?.isChecked = true
                    lifecycleScope.launch {
                        delay(100)
                        binding?.bottomNav?.visibility = View.VISIBLE
                    }
                }
                else -> binding?.bottomNav?.visibility = View.GONE
            }
        }
    }
}