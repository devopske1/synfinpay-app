package com.example.synfinpay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.synfinpay.databinding.ItemTransactionsLayoutBinding
import com.example.synfinpay.databinding.ItemVerifyTransactionBinding

class TransactionAdapter(private val listener: OnTransactionAdapterItemClicked) :
    ListAdapter<TransactionItems, TransactionAdapter.ViewHolder>(DIFF_UTIL) {
    private lateinit var binding: ItemVerifyTransactionBinding

    class ViewHolder(val binding: ItemVerifyTransactionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding =
            ItemVerifyTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction = getItem(position)
        holder.binding.apply {
            tvDate.text = transaction.date
            tvCategoryName.text = transaction.category
            btnSetLimit.text = transaction.setLimit
            tvClaim.text = transaction.claim

            root.setOnClickListener {
                listener.onTransactionItemClicked(transaction)
            }
            imgForward.apply {
                setOnClickListener {
                    listener.onTransactionItemClicked(transaction)
                }
            }
        }
    }

}


private val DIFF_UTIL = object : DiffUtil.ItemCallback<TransactionItems>() {
    override fun areItemsTheSame(
        oldItem: TransactionItems,
        newItem: TransactionItems
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: TransactionItems,
        newItem: TransactionItems
    ): Boolean {
        return oldItem == newItem
    }


}

interface OnTransactionAdapterItemClicked {
    fun onTransactionItemClicked(transactionItems: TransactionItems)
}


data class TransactionItems(
    val category: String,
    val date: String,
    val setLimit: String,
    val claim: String
)