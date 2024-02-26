package com.example.synfinpay.views

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentUserProfileManagementBinding


class UserProfileManagementFragment : androidx.fragment.app.Fragment()
{
    private lateinit var binding: FragmentUserProfileManagementBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding= FragmentUserProfileManagementBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvChangePassword.setOnClickListener {
            findNavController().navigate(R.id.changePasswordFragment)
        }

        binding.cvLogout.setOnClickListener {
            logout()

        }



    }
    private fun logout() {

        val intent = Intent(requireActivity(),SignInFragment::class.java)
        startActivity(intent)
        requireActivity().finish() // This will close the current activity
    }

    private  fun editProfilePic(){

    }
}
