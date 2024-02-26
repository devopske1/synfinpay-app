package com.example.synfinpay.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentForgotPasswordCodeBinding
import com.example.synfinpay.utils.setToolbarTitleTransparent


class ForgotPasswordCodeFragment : Fragment() {

    private lateinit var binding: FragmentForgotPasswordCodeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordCodeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnChangePassword.setOnClickListener {
            findNavController().navigate(R.id.changePasswordFragment)
        }

        binding.edtCode.addTextChangedListener {
            if (validateFields()) {
                binding.btnResend.setBackgroundDrawable(resources.getDrawable(R.drawable.button_blue_bcakground))
                binding.btnChangePassword.setBackgroundDrawable(resources.getDrawable(R.drawable.button_blue_bcakground))
                binding.btnChangePassword.isEnabled = true
                binding.btnResend.isEnabled = true
            }
        }


        binding.btnResend.setOnClickListener {
            if (validateFields()) {
                findNavController().navigate(R.id.forgotPasswordCodeFragment)
            }
        }
        binding.btnChangePassword.setOnClickListener {
            if(validateFields()) {
                findNavController().navigate(R.id.changePasswordFragment)
            }
        }


    }

    private fun validateFields(): Boolean {
        val code = binding.edtCode.text.toString().trim()
        if (code.isEmpty()) {
            binding.edtCode.error = "field is required"
            return false
        }
        if (code.length != 4) {
            binding.edtCode.error = "Should be a ten-digit"
            return false
        }
        return true
    }
    }
