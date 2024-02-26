package com.example.synfinpay.roomDb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    //insert user data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserData(user: UserEntity): Long

    //insert expense data
    @Insert
    fun insertExpense(expense: ExpenseEntity): Long

    //retrieve expense data
    @Query("SELECT * FROM Expenses")
    fun getAllExpenses(): List<ExpenseEntity>

    @Insert
    fun insertStock(stock: StockEntity): Long

    //retrieve expense data
    @Query("SELECT * FROM Stock")
    fun getAllStock(): List<StockEntity>
}

