package com.example.synfinpay.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentChangePasswordBinding
import com.example.synfinpay.utils.setToolbarTitleTransparent


class ChangePasswordFragment : Fragment() {

    private lateinit var binding: FragmentChangePasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChangePasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

      binding.edtConfirmPassword.addTextChangedListener {
          if(validateFields()){
              binding.btnChangePassword.setBackgroundDrawable(resources.getDrawable(R.drawable.button_blue_bcakground))
              binding.btnChangePassword.isEnabled = true

          }
      }
        binding.btnChangePassword.setOnClickListener {
            if (validateFields()) {
                findNavController().navigate(R.id.changePasswordSuccessFragment)
            }
        }


    }

    private fun validateFields(): Boolean {
        val password = binding.edtNewPassword.text.toString().trim()
        val confirmPassword = binding.edtConfirmPassword.text.toString().trim()
        if (password.isEmpty()) {
            binding.edtNewPassword.error = "Enter Password"
            return false
        }
        if (confirmPassword.isEmpty()) {
            binding.edtConfirmPassword.error = "Confirm Password"
            return false
        }

        if (password != confirmPassword) {
            binding.edtConfirmPassword.error = "passwords do not match"
            return false
        }
        return true
    }

}