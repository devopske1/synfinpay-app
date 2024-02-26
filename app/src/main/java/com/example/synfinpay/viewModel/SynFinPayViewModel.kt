package com.example.synfinpay.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.synfinpay.repository.UserRepositoryImpl
import com.example.synfinpay.roomDb.ExpenseEntity
import com.example.synfinpay.roomDb.StockEntity
import com.example.synfinpay.roomDb.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SynFinPayViewModel(
    val app: Application,
    val userRepository: UserRepositoryImpl
) : AndroidViewModel(
    app
){
     fun saveUserData(user:UserEntity){
        viewModelScope.launch(context = Dispatchers.IO){
            userRepository.insertUserData(user)
        }
    }

    fun saveExpenseData(expense: ExpenseEntity) {
        viewModelScope.launch(context = Dispatchers.IO) {
            userRepository.insertExpenseData(expense)
        }
    }

    fun getExpenseData(onDataReceived: (List<ExpenseEntity>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val expenses = userRepository.getExpenseData()
            onDataReceived(expenses)
        }
    }

    fun saveStockData(stock: StockEntity) {
        viewModelScope.launch(context = Dispatchers.IO) {
            userRepository.insertStockData(stock)
        }
    }

    fun getStockData(onStockReceived: (List<StockEntity>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val stock= userRepository.getStockData()
            onStockReceived(stock)
        }
    }
}