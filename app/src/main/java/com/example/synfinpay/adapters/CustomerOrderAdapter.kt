package com.example.synfinpay.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.synfinpay.databinding.ItemCustomerBinding

class CustomerOrderAdapter (private val listener: OnCustomerAdapterItemClickedListener): ListAdapter<CustomerOrder, CustomerOrderAdapter.ViewHolder>(DIFF_UTIL) {
        class ViewHolder(val binding: ItemCustomerBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding =
                ItemCustomerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val select = getItem(position)
            holder.binding.apply {
                tvCategoryName.text = select.customerName.toString()
                tvDate.text = select.date
                btnSetLimit.text = select.total
                tvClaim.text = select.numberOfItems.toString()

                root.setOnClickListener {
                    listener.onItemClicked(it, select)
                }

                imgForward.apply {
                    setOnClickListener {
                        listener.onItemClicked(it, select)
                    }
                }
            }

        }
    }
    private val DIFF_UTIL = object : DiffUtil.ItemCallback<CustomerOrder>() {
        override fun areItemsTheSame(
            oldItem: CustomerOrder,
            newItem: CustomerOrder
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CustomerOrder,
            newItem: CustomerOrder
        ): Boolean {
            return oldItem == newItem
        }


    }
    interface  OnCustomerAdapterItemClickedListener {
        fun onItemClicked(view: View, model: CustomerOrder)
    }
    data class CustomerOrder(
        val customerName: String,
        val date:String,
        val total:String,
        val numberOfItems:Int
    )
