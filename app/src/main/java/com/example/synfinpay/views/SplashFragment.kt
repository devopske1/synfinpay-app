package com.example.synfinpay.views

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentSplashBinding
import com.example.synfinpay.utils.SynFinSharedPreferences
import com.example.synfinpay.utils.Utils.setStatusBarColor


class SplashFragment : Fragment() {


    private lateinit var binding: FragmentSplashBinding
    private lateinit var synFinPrefs: SynFinSharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setStatusBarColor()
        synFinPrefs= SynFinSharedPreferences(requireContext())

        Handler().postDelayed({
            checkFirstTimeUser()
        }, 3000)

        setUpOnBackPressedCallback()
    }

    private fun checkFirstTimeUser() {
        val isFirstTimeUser = synFinPrefs.getIsFirstTimerUser()
        if (isFirstTimeUser) {
            findNavController()
                .navigate(R.id.onBoardingFragment)
        } else {
            findNavController()
                .navigate(R.id.signInFragment)
        }

    }

    private fun setUpOnBackPressedCallback() {
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finishAffinity()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(requireActivity(), callback)
    }
}