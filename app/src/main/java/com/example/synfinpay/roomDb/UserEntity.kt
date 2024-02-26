package com.example.synfinpay.roomDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey()
    var userEmail:String,
    var phoneNumber:String,
    var password:String
)


@Entity(tableName = "Expenses")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val expenseType: String,
    val amount: String,
    val date: String
)



@Entity(tableName = "Stock")
data class StockEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val inventory: String,
    val quantity: String,
    val total: String
)
