package com.example.synfinpay.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.synfinpay.repository.UserRepository
import com.example.synfinpay.repository.UserRepositoryImpl

//class SynFinViewModelFactory(
//    private val application: Application,
//    private val userRepository: UserRepositoryImpl
//) : ViewModelProvider.Factory {
//    fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(SynFinPayViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return SynFinPayViewModel(application, userRepository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}





