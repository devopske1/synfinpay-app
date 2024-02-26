package com.example.synfinpay.repository

import com.example.synfinpay.roomDb.ExpenseEntity
import com.example.synfinpay.roomDb.StockEntity
import com.example.synfinpay.roomDb.UserEntity

interface UserRepository {
    fun insertUserData(user:UserEntity):Long

    fun insertExpenseData(expense: ExpenseEntity): Long

    fun getExpenseData(): List<ExpenseEntity>

    fun insertStockData(expense: StockEntity): Long

    fun getStockData(): List<StockEntity>
}