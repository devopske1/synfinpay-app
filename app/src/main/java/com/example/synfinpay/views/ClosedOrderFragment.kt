package com.example.synfinpay.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synfinpay.R
import com.example.synfinpay.adapters.OnSelectOrderAdapterItemClickedListener
import com.example.synfinpay.adapters.SelectItems
import com.example.synfinpay.adapters.SelectOrderAdapter
import com.example.synfinpay.databinding.FragmentClosedOrderBinding


class ClosedOrderFragment : Fragment() {
private lateinit var binding: FragmentClosedOrderBinding
private lateinit var selectOrderAdapter: SelectOrderAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentClosedOrderBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        initRecyclerView()
        selectOrderAdapter.submitList(dummyClosedOrder())
    }
    private fun initRecyclerView(){
        selectOrderAdapter = SelectOrderAdapter(object: OnSelectOrderAdapterItemClickedListener {
            override fun onItemClicked(view: View, select: SelectItems) {
                findNavController().navigate(R.id.orderFragment2)
            }
        }
        )

        binding.recyclerClosedOrder.apply{
            adapter = selectOrderAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }



    }

    private fun dummyClosedOrder(): List<SelectItems> {
        return listOf(
            SelectItems(
                "Order No: 002M",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),
            SelectItems(
                "Order No: 002M",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),
            SelectItems(
                "Order No: 002M",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),
            SelectItems(
                "Order No: 002M",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),
            SelectItems(
                "Order No: 002M",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),
            SelectItems(
                "Order No: 002M",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),
            SelectItems(
                "Order No: 002M",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),

            )


    }

}