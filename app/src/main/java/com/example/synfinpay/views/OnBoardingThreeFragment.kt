package com.example.synfinpay.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentOnboardingThreeBinding


class OnBoardingThreeFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentOnboardingThreeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignIn.setOnClickListener {
            findNavController().navigate(R.id.signInFragment)
        }

        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.signupFragment)
        }

    }


}