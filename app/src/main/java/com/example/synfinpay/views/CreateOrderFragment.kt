package com.example.synfinpay.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synfinpay.R
import com.example.synfinpay.adapters.CategoryAdapter
import com.example.synfinpay.adapters.CategoryItems
import com.example.synfinpay.adapters.OnCategoryAdapterItemClickedListenerr
import com.example.synfinpay.adapters.OnPopularItemClickedListenerr
import com.example.synfinpay.adapters.PopularItems
import com.example.synfinpay.adapters.PopularProductsAdapter
import com.example.synfinpay.adapters.TransactionAdapter
import com.example.synfinpay.adapters.TransactionItems
import com.example.synfinpay.databinding.FragmentCreateOrderBinding


class CreateOrderFragment : Fragment() {
    private lateinit var binding: FragmentCreateOrderBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var popularAdapter: PopularProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateOrderBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

        initRecyclerView()
        categoryAdapter.submitList(dummyCategories())
        initRecyclerViewPopular()
        popularAdapter.submitList(dummyPopular())

        binding.shopCart.setOnClickListener {
            findNavController().navigate(R.id.mycCartFragment2)
        }

    }

    private fun initRecyclerView() {
        categoryAdapter = CategoryAdapter(object : OnCategoryAdapterItemClickedListenerr {
            override fun onItemClicked(view: View, model: CategoryItems) {
                findNavController().navigate(R.id.softDrinksFragment2)

            }
        })
        // Set up RecyclerView with GridLayoutManager
        binding.recyclerCategories.apply {
            adapter = categoryAdapter
           layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }// Display three items horizontally


    }

    private fun initRecyclerViewPopular() {

        popularAdapter = PopularProductsAdapter(object : OnPopularItemClickedListenerr {
            override fun onItemClicked(view: View, model: PopularItems) {
                findNavController().navigate(R.id.selectOrderFragment)

            }
        })
        // Set up RecyclerView with GridLayoutManager
        binding.recyclerPopular.apply {
            adapter = popularAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }


}

private fun dummyCategories(): List<CategoryItems> {
    return listOf(
        CategoryItems(
            R.drawable.bev,
            "Beverages",
            "Mirinda"

        ),
//        CategoryItems(
//            R.drawable.bev,
//            "Beverages",
//            "Mirinda"
//        ),
//
//        CategoryItems(
//            R.drawable.bev,
//            "Beverages",
//            "Mirinda"
//
//        ),
//        CategoryItems(
//            R.drawable.bev,
//            "Beverages",
//            "Mirinda"
//
//        ),
//        CategoryItems(
//            R.drawable.bev,
//            "Beverages",
//            "Mirinda"
//
//        ),
//        CategoryItems(
//            R.drawable.bev,
//            "Beverages",
//            "Mirinda"
//
//        )

    )


}

private fun dummyPopular(): List<PopularItems> {
    return listOf(
        PopularItems(

            R.drawable.wine,
            "Wine",
            "KES 1000",
            "*****"
        ),
        PopularItems(

            R.drawable.wine,
            "Wine",
            "KES 1000",
            "*****"
        ),
        PopularItems(

            R.drawable.wine,
            "Wine",
            "KES 1000",
            "*****"
        ),
        PopularItems(

            R.drawable.wine,
            "Wine",
            "KES 1000",
            "*****"
        ),
        PopularItems(

            R.drawable.wine,
            "Wine",
            "KES 1000",
            "*****"
        ),
    )


}


