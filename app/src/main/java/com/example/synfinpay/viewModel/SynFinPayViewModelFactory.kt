package com.example.synfinpay.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.synfinpay.repository.UserRepository
import com.example.synfinpay.repository.UserRepositoryImpl

class SynFinPayViewModelFactory
    (
    val app: Application,
val userRepository: UserRepositoryImpl
) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(SynFinPayViewModel(app, userRepository)::class.java)){
                return SynFinPayViewModel(app, userRepository) as T
            }
            throw IllegalArgumentException("Unknown viewmodel")
        }
    }

