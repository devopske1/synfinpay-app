package com.example.synfinpay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.synfinpay.databinding.ItemStockInBinding


class StockInAdapter(): ListAdapter<StockIn, StockInAdapter.ViewHolder>(DIFF_UTIL) {
        class ViewHolder(val binding: ItemStockInBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding =
                ItemStockInBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val select = getItem(position)
            holder.binding.apply {
                tvInventory.text = select.inventory
                tvQuantity.text = select.quantity
                tvTotalValue.text = select.totalValue


            }
        }

    }

    private val DIFF_UTIL = object : DiffUtil.ItemCallback<StockIn>() {
        override fun areItemsTheSame(
            oldItem: StockIn,
            newItem: StockIn
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: StockIn,
            newItem: StockIn
        ): Boolean {
            return oldItem == newItem
        }
    }

    data class StockIn(
        val inventory: String,
        val quantity:String,
        val totalValue:String
    )
