package com.example.synfinpay.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentSignInBinding
import com.example.synfinpay.utils.Utils.setStatusBarColorBlue
import com.example.synfinpay.utils.setToolbarTitle

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSignInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setStatusBarColorBlue()

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        setUpOnBackPressedCallback()
        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }

        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.forgotPasswordFragment)
        }
        binding.edtPassword.addTextChangedListener {
            if(validateFields()){
                binding.btnSignIn.setBackgroundDrawable(resources.getDrawable(R.drawable.button_blue_bcakground))
                binding.btnSignIn.isEnabled = true

            }
        }
        binding.btnSignIn.setOnClickListener {
            if(validateFields()) {
                findNavController().navigate(R.id.dashboardFragment)
            }
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

    private fun validateFields(): Boolean {
        val userEmail = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()
        if (userEmail.isEmpty()) {
            binding.edtEmail.error = ("field is required")
            return false
        }
        else if (password.isEmpty()) {
            binding.edtPassword.error = "field is required"
            return false
        }
        return true
    }
}