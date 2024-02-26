package com.example.synfinpay.views

import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentHomeHomeMainBinding


class HomeHomeMainFragment : Fragment() {
    private lateinit var binding:FragmentHomeHomeMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeHomeMainBinding.inflate(layoutInflater)
        return binding.root
    }

}