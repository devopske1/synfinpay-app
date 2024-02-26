package com.example.synfinpay.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.synfinpay.databinding.ItemBeverageCategoryBinding

class CategoryAdapter(private val listener: OnCategoryAdapterItemClickedListenerr):ListAdapter<CategoryItems, CategoryAdapter.ViewHolder>(DIFF_UTIL) {
        private lateinit var binding: ItemBeverageCategoryBinding

        class ViewHolder(val binding: ItemBeverageCategoryBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            binding =
                ItemBeverageCategoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return ViewHolder(binding)
        }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val transaction = getItem(position)
            holder.binding.apply {
                tvBev.text = transaction.title
                tvBevDesc.text = transaction.desc
                imgRecycler.setImageResource(transaction.image)

                root.setOnClickListener {
                    listener.onItemClicked(it, transaction)
                }

                imgPlus.apply {
                    setOnClickListener {
                        listener.onItemClicked(it, transaction)
                    }
                }


            }
        }

    }


    private val DIFF_UTIL = object : DiffUtil.ItemCallback<CategoryItems>() {
        override fun areItemsTheSame(
            oldItem: CategoryItems,
            newItem: CategoryItems
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CategoryItems,
            newItem: CategoryItems
        ): Boolean {
            return oldItem == newItem
        }


    }

interface OnCategoryAdapterItemClickedListenerr {
        fun onItemClicked(view: View, model: CategoryItems)
}
    data class CategoryItems(
        val image: Int,
        val title: String,
        val desc: String,

    )
