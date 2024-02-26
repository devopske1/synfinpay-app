package com.example.synfinpay.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.synfinpay.databinding.FragmentDashboardBinding


class DashboardFragment : androidx.fragment.app.Fragment() {
private lateinit var binding:FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(layoutInflater)
        return binding.root
    }



    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigation= binding.btmNav
        val hostFragment =childFragmentManager.findFragmentById(binding.nvHost.id)
        val  navController =hostFragment?.findNavController()


            navController.let {
            if (it != null) {
                bottomNavigation.setupWithNavController(it)
            }

        }

    }


}