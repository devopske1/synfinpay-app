package com.example.synfinpay.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.synfinpay.R
import com.example.synfinpay.databinding.ItemSoftDrinkBinding

class SoftDrinkAdapter(private val listener: OnSoftDrinkAdapterItemClickedListener) :
    ListAdapter<SoftDrinkItems, SoftDrinkAdapter.ViewHolder>(DIFF_UTIL) {
    var totalAmount: Double = 0.0
        private set

    class ViewHolder(val binding: ItemSoftDrinkBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemSoftDrinkBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val softDrink = getItem(position)
        holder.binding.apply {
            tvProductName.text = softDrink.title
            tvPrice.text = softDrink.price.toString()
            tvOriginalPrice.text = softDrink.originalPrice
            tvOffer.text = softDrink.offer
            imgRecycler.setImageResource(softDrink.image)
            tvItemCount.text = softDrink.itemCount.toString()

            cardView.setOnLongClickListener {
                listener.onItemLongClicked(it, softDrink)

                // Toggle the isSelected state
                softDrink.isSelected = !softDrink.isSelected

                // Update the background color based on the isSelected state
                updateItemSelectionBackground(cardView, softDrink.isSelected)
                true
            }
            // Update the background color based on the isSelected state
            updateItemSelectionBackground(cardView, softDrink.isSelected)


            tvAdd.setOnClickListener {
                if (softDrink.itemCount >= 0) {
                    softDrink.itemCount++
                    tvItemCount.text = softDrink.itemCount.toString()

                    val totalPrice = softDrink.price.toDouble() * softDrink.itemCount
                    tvOriginalPrice.text = totalPrice.toString()  // Update the displayed price

                    // Notify the listener or update UI as needed
                    listener.onItemClicked(it, softDrink)
                    updateSubtotal()
                }
            }

            tvSubtract.setOnClickListener {
                if (softDrink.itemCount >= 1) {
                    softDrink.itemCount--
                    tvItemCount.text = softDrink.itemCount.toString()

                    val totalPrice = softDrink.price.toDouble() * softDrink.itemCount
                    tvOriginalPrice.text = totalPrice.toString() // Update the displayed price

                    // Notify the listener or update UI as needed
                    listener.onItemClicked(it, softDrink)
                    updateSubtotal()
                }
            }


        }
    }
    fun removeItem(softDrink: SoftDrinkItems) {
        val position = currentList.indexOf(softDrink)
        if (position != -1) {
            val newList = currentList.toMutableList()
            newList.removeAt(position)
            submitList(newList.toList())
            updateTotalAmount(calculateTotalAmount()) // Use toList() to create a new immutable list
        }
    }

    fun getSelectedSoftDrink(): SoftDrinkItems? {
        return currentList.firstOrNull { it.isSelected }
    }

    private fun updateTotalAmount(amount: Double) {
        totalAmount += amount
        // Notify any listener or update UI as needed with the new total amount
    }

    fun updateSubtotal() {
        totalAmount = calculateTotalAmount()
        // Notify any listener or update UI as needed with the new total amount
        listener.onSubtotalUpdated(totalAmount)
    }

    fun calculateTotalAmount(): Double {
        return currentList.sumByDouble { it.price.toDouble() * it.itemCount }
    }

    fun updateItemSelectionBackground(view: View, isSelected: Boolean) {
        if (isSelected) {
            view.setBackgroundResource(R.color.primary)
        } else {
            view.setBackgroundResource(R.color.tabGray)
        }
    }
}


private val DIFF_UTIL = object : DiffUtil.ItemCallback<SoftDrinkItems>() {
    override fun areItemsTheSame(
        oldItem: SoftDrinkItems,
        newItem: SoftDrinkItems
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: SoftDrinkItems,
        newItem: SoftDrinkItems
    ): Boolean {
        return oldItem == newItem
    }


}

interface OnSoftDrinkAdapterItemClickedListener {
    fun onItemClicked(view: View, softDrink: SoftDrinkItems)
    fun onItemLongClicked(view: View, softDrink: SoftDrinkItems)
    fun onSubtotalUpdated(subtotal: Double)
}

data class SoftDrinkItems(
    val image: Int,
    val title: String,
    val price: String,
    val originalPrice: String,
    val offer: String,
    var itemCount: Int = 1,
    var isSelected: Boolean = false

) {
//    get() = itemCount * originalPrice.toDouble().toString().toInt()
}