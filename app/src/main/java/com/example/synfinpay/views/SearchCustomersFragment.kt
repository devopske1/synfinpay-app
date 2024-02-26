package com.example.synfinpay.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synfinpay.R
import com.example.synfinpay.adapters.CustomerOrder
import com.example.synfinpay.adapters.CustomerOrderAdapter
import com.example.synfinpay.adapters.OnCustomerAdapterItemClickedListener
import com.example.synfinpay.databinding.FragmentSearchCustomersBinding


class SearchCustomersFragment : Fragment() {
private lateinit var binding: FragmentSearchCustomersBinding
private lateinit var customerOrderAdapter: CustomerOrderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentSearchCustomersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        initRecyclerView()
      customerOrderAdapter.submitList(dummyCustomer())
    }

    private fun initRecyclerView(){
      customerOrderAdapter = CustomerOrderAdapter(object: OnCustomerAdapterItemClickedListener {
            override fun onItemClicked(view: View, select: CustomerOrder) {
                findNavController().navigate(R.id.charlesMwambireFragment)
            }
        }
        )

        binding.rvCustomers.apply{
            adapter = customerOrderAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }



    }

    private fun dummyCustomer(): List<CustomerOrder> {
        return listOf(
           CustomerOrder(
                "Charles Mwambire",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),
            CustomerOrder(
                "Charles Mwambire",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),
            CustomerOrder(
                "Charles Mwambire",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),
            CustomerOrder(
                "Charles Mwambire",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),




            )


    }
}

