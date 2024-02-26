package com.example.synfinpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.synfinpay.repository.UserRepository
import com.example.synfinpay.repository.UserRepositoryImpl
import com.example.synfinpay.roomDb.UserDatabase
import com.example.synfinpay.viewModel.SynFinPayViewModel
import com.example.synfinpay.viewModel.SynFinPayViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
private lateinit var bottomNavigationView: BottomNavigationView
    lateinit var viewModel:SynFinPayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userRepository = UserRepositoryImpl(
            UserDatabase(
                this
            )
        )
        val viewModelFactory = SynFinPayViewModelFactory(application, userRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SynFinPayViewModel::class.java)


//
//        // Set up bottom navigation listener
//        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.nav_home -> {
//                    findNavController(R.id.nav_host_fragment).navigate(R.id.homeFragment)
//                    return@setOnNavigationItemSelectedListener true
//                }
//                // Add cases for other menu items if needed
//            }
//            false
//        }

        // Observe the NavHostFragment's navigation events
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
//            // Check if the destination is your DashboardFragment
//            if (destination.id == R.id.dashboardFragment) {
//                // Hide bottom navigation view
//                bottomNavigationView.visibility = View.GONE
//            } else {
//                // Show bottom navigation view for other fragments
//                bottomNavigationView.visibility = View.VISIBLE
//            }
//        }
    }
}



















