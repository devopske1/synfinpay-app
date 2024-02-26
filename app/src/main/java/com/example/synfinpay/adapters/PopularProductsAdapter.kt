package com.example.synfinpay.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.synfinpay.databinding.ItemPopularProductBinding

class PopularProductsAdapter(private val listener: OnPopularItemClickedListenerr):
        ListAdapter<PopularItems,PopularProductsAdapter.ViewHolder>(DIFF_UTIL) {
        private lateinit var binding: ItemPopularProductBinding

        class ViewHolder(val binding:ItemPopularProductBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            binding =
               ItemPopularProductBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return ViewHolder(binding)
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val popular = getItem(position)
            holder.binding.apply {
                tvProductName.text = popular.productName
                tvPrice.text = popular.price
                imgRecycler.setImageResource(popular.image)


                root.setOnClickListener {
                    listener.onItemClicked(it, popular)
                }

                tvViewMore.apply {
                    setOnClickListener {
                        listener.onItemClicked(it, popular)
                    }
                }


            }
        }

    }


    private val DIFF_UTIL = object : DiffUtil.ItemCallback<PopularItems>() {
        override fun areItemsTheSame(
            oldItem: PopularItems,
            newItem: PopularItems
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: PopularItems,
            newItem: PopularItems
        ): Boolean {
            return oldItem == newItem
        }


    }

    interface OnPopularItemClickedListenerr {
        fun onItemClicked(view: View, model: PopularItems)
    }
    data class PopularItems(
        val image: Int,
        val productName: String,
        val price: String,
        val stars: String

        )

