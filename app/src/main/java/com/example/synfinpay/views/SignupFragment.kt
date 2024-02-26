package com.example.synfinpay.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.MainActivity
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentSignUpBinding
import com.example.synfinpay.roomDb.UserEntity
import com.example.synfinpay.utils.SynFinSharedPreferences
import com.example.synfinpay.utils.Utils.setStatusBarColorBlue
import com.example.synfinpay.utils.setToolbarTitle
import com.example.synfinpay.viewModel.SynFinPayViewModel

class SignUpFragment : Fragment() {
    private lateinit var synFinPrefs: SynFinSharedPreferences

    private lateinit var viewModel: SynFinPayViewModel
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setStatusBarColorBlue()
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        setUpOnBackPressedCallback()
        viewModel = (activity as MainActivity).viewModel
        synFinPrefs = SynFinSharedPreferences(requireContext())

        binding.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.signInFragment)
        }


        binding.edtPassword.addTextChangedListener {
            if (validateFields()) {
                binding.btnSignUp.setBackgroundDrawable(resources.getDrawable(R.drawable.button_blue_bcakground))
                binding.btnSignUp.isEnabled = true

            }
        }

        binding.btnSignUp.setOnClickListener {
            if (validateFields()) {
                val userEmail = binding.edtEmail.text.toString().trim()
                val phoneNumber = binding.edtphone.text.toString().trim()
                val password = binding.edtPassword.text.toString().trim()
                viewModel.saveUserData(
                    UserEntity(
                        userEmail = userEmail,
                        phoneNumber = phoneNumber,
                        password = password
                    )
                )
                synFinPrefs.setIsFirstTimerUser(false)
                findNavController().navigate(R.id.signInFragment)
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
        val phoneNumber = binding.edtphone.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()
        if (userEmail.isEmpty()) {
            binding.edtEmail.error = ("field is required")
            return false
        }
        if (phoneNumber.isEmpty()) {
            binding.edtphone.error = ("field is required")
            return false

        }
        if (password.isEmpty()) {
            binding.edtPassword.error = "field is required"
            return false
        }
        return true
    }


}