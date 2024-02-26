package com.example.synfinpay.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentOnboardingTwoBinding


class OnBoardingTwoFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentOnboardingTwoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardViewNext.setOnClickListener {
            findNavController().navigate(R.id.onboardingThreeFragment)
        }
    }


}