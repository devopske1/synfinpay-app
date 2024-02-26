package com.example.synfinpay.repository

import com.example.synfinpay.roomDb.ExpenseEntity
import com.example.synfinpay.roomDb.StockEntity
import com.example.synfinpay.roomDb.UserDatabase
import com.example.synfinpay.roomDb.UserEntity

class UserRepositoryImpl(val db: UserDatabase):UserRepository {
    override fun insertUserData(user: UserEntity): Long =
       db.userDao().insertUserData(user)

    override fun insertExpenseData(expense: ExpenseEntity): Long =
        db.userDao().insertExpense(expense)

    override fun getExpenseData(): List<ExpenseEntity> =
        db.userDao().getAllExpenses()

    override fun insertStockData(stock: StockEntity): Long =
        db.userDao().insertStock(stock)

    override fun getStockData(): List<StockEntity> =
        db.userDao().getAllStock()
}