package com.example.synfinpay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.synfinpay.databinding.ItemExpenseBinding


class ExpenseAdapter  (): ListAdapter<Expenses, ExpenseAdapter.ViewHolder>(DIFF_UTIL) {
    class ViewHolder(val binding: ItemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
           ItemExpenseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val select = getItem(position)
        holder.binding.apply {
      tvExpenseType.text = select.expenseType
            tvAmount.text = select.amount.toString()
           tvDate.text = select.date


            }
        }

    }

private val DIFF_UTIL = object : DiffUtil.ItemCallback<Expenses>() {
    override fun areItemsTheSame(
        oldItem: Expenses,
        newItem: Expenses
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: Expenses,
        newItem: Expenses
    ): Boolean {
        return oldItem == newItem
    }
}

data class Expenses(
    val expenseType: String,
    val amount:String,
    val date:String
        )