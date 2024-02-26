//package com.example.synfinpay.ui.adapters
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ListAdapter
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.example.synfinpay.databinding.ItemBeverageCategoryBinding
//
//class CategoriesAdapter(private val listener: OnCategoryAdapterItemClickedListenerr) :
//    ListAdapter<Categories, CategoriesAdapter.ViewHolder>(DIFF_UTIL) {
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding =
//            ItemBeverageCategoryBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val lead = getItem(position)
//        //bind card details
//        holder.item
//            .apply {
//
//
//                imgRecycler.setImageResource(lead.image)
//                tvBev.text = lead.title
//                tvBevDesc.text = lead.desc
//
//                root.setOnClickListener {
//                    listener.onItemClicked(it, lead)
//                }
//
//                imgPlus.apply {
//                    setOnClickListener {
//                        listener.onItemClicked(it, lead)
//                    }
//
//
//                }
//
//
//            }
//    }
//
//
//    class ViewHolder(val item: ItemBeverageCategoryBinding) :
//        RecyclerView.ViewHolder(item.root) {
//    }
//
//
//}
//
//private val DIFF_UTIL = object : DiffUtil.ItemCallback<Categories>() {
//    override fun areItemsTheSame(
//        oldItem: Categories,
//        newItem: Categories
//    ): Boolean {
//        return oldItem == newItem
//    }
//
//    override fun areContentsTheSame(
//        oldItem: Categories,
//        newItem: Categories
//    ): Boolean {
//        return oldItem == newItem
//    }
//
//}
//
//
//interface OnCategoryAdapterItemClickedListenerr {
//    fun onItemClicked(view: View, model: Categories)
//}
//
//data class Categories(
//    val image: Int,
//    val title: String,
//    val desc: String
//)
