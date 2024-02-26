package com.example.synfinpay.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentForgotPasswordBinding
import com.example.synfinpay.utils.Utils.setStatusBarColorWhite
import com.example.synfinpay.utils.setToolbarTitleTransparent

class ForgotPasswordFragment : Fragment() {


    private lateinit var binding: FragmentForgotPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setStatusBarColorWhite()

    binding.back.setOnClickListener {
        findNavController().navigateUp()
    }

        binding.edtPhone.addTextChangedListener {
            if (validateFields()) {
                binding.btnSend.setBackgroundDrawable(resources.getDrawable(R.drawable.button_blue_bcakground))
                binding.btnSend.isEnabled = true
            }
        }


        binding.btnSend.setOnClickListener {
            if (validateFields()) {
                findNavController().navigate(R.id.forgotPasswordCodeFragment)
            }
        }


    }

    private fun validateFields(): Boolean {
        val phoneNumber = binding.edtPhone.text.toString().trim()
        if (phoneNumber.isEmpty()) {
            binding.edtPhone.error = "field is required"
            return false
        }
        if (phoneNumber.length != 10) {
            binding.edtPhone.error = "Should be a ten-digit"
            return false
        }
        return true
    }
}
