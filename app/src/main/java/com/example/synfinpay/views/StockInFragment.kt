package com.example.synfinpay.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synfinpay.MainActivity
import com.example.synfinpay.R
import com.example.synfinpay.adapters.StockIn
import com.example.synfinpay.adapters.StockInAdapter
import com.example.synfinpay.databinding.FragmentStockInBinding
import com.example.synfinpay.viewModel.SynFinPayViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class StockFragment : Fragment() {
    private lateinit var binding: FragmentStockInBinding
    private lateinit var stockInAdapter: StockInAdapter
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var viewModel:SynFinPayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      binding = FragmentStockInBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = (activity as MainActivity).viewModel
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.addStockFragment2)
        }

    initRecyclerView()

        initRecyclerView()
        stockInAdapter.submitList(dummyStock())

//        viewModel.getStockData { stock ->
//            stockInAdapter.submitList(stock)
//        }
}
private fun initRecyclerView(){
    stockInAdapter = StockInAdapter()
    binding.rvTithePaymentsItems.apply{
        adapter = stockInAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }



}

private fun dummyStock(): List<StockIn> {
    return listOf(
       StockIn(
            "Gummies",
            "120",
            "Kes 100,000",
        ),
        StockIn(
            "Gummies",
            "120",
            "Kes 100,000",
        ),
        StockIn(
            "Gummies",
            "120",
            "Kes 100,000",
        ),
        StockIn(
            "Gummies",
            "120",
            "Kes 100,000",
        ),
        StockIn(
            "Gummies",
            "120",
            "Kes 100,000",
        ),
        StockIn(
            "Gummies",
            "120",
            "Kes 100,000",
        ),
        StockIn(
            "Gummies",
            "120",
            "Kes 100,000",
        ),
        StockIn(
            "Gummies",
            "120",
            "Kes 100,000",
        ),



        )


}


}