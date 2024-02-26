package com.example.synfinpay.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.synfinpay.databinding.ItemSelectOrderBinding

class SelectOrderAdapter(private val listener: OnSelectOrderAdapterItemClickedListener): ListAdapter<SelectItems, SelectOrderAdapter.ViewHolder>(DIFF_UTIL) {
    class ViewHolder(val binding: ItemSelectOrderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemSelectOrderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val select = getItem(position)
        holder.binding.apply {
            tvCategoryName.text = select.orderNo.toString()
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
private val DIFF_UTIL = object : DiffUtil.ItemCallback<SelectItems>() {
    override fun areItemsTheSame(
        oldItem: SelectItems,
        newItem: SelectItems
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: SelectItems,
        newItem: SelectItems
    ): Boolean {
        return oldItem == newItem
    }


}
interface  OnSelectOrderAdapterItemClickedListener {
    fun onItemClicked(view: View, model: SelectItems)
}
data class SelectItems(
    val orderNo: String,
    val date:String,
    val total:String,
    val numberOfItems:Int
)