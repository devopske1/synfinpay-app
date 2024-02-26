package com.example.synfinpay.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding= FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.cvChangePassword.setOnClickListener {
            findNavController().navigate(R.id.changePasswordFragment2)
        }

        binding.cvLogout.setOnClickListener {
            logout()

        }



    }
    private fun logout() {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.nvHost, SignInFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }


    private  fun editProfilePic(){

    }
}