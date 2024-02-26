package com.example.synfinpay.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synfinpay.R
import com.example.synfinpay.adapters.OnTransactionAdapterItemClicked
import com.example.synfinpay.adapters.TransactionAdapter
import com.example.synfinpay.adapters.TransactionItems
import com.example.synfinpay.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var transactionsAdapter: TransactionAdapter
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        transactionsAdapter.submitList(dummyTransactions())


        binding.cardViewProfile.setOnClickListener {
            findNavController().navigate(R.id.profileFragment2)
        }
        binding.btnVerify.setOnClickListener {
            findNavController().navigate(R.id.verifyTransactionFragment)
        }
        binding.cardViewExpense.setOnClickListener {
            findNavController().navigate(R.id.expenseRecordFragment2)
        }
        binding.cardViewStockIn.setOnClickListener {
            findNavController().navigate(R.id.stockFragment)
        }
        binding.cardViewTransactions.setOnClickListener {
            findNavController().navigate(R.id.transactionsFragment)
        }
        binding.cardViewOrders.setOnClickListener {
            findNavController().navigate(R.id.searchCustomersFragment)
        }

    }

    private fun initRecyclerView() {
        transactionsAdapter = TransactionAdapter(object : OnTransactionAdapterItemClicked {
            override fun onTransactionItemClicked(transactionItems: TransactionItems) {

            }
        })
        binding.recycler.apply {
            adapter = transactionsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

    private fun dummyTransactions(): List<TransactionItems> {
        return listOf(
            TransactionItems(
                "AWEQE3245TEDRF",
                "12/12/2022",
                "KES 800",
                "claim"


            ),

            TransactionItems(
                "AWEQHG5TEDRF",
                "12/12/2022",
                "KES 1000",
                "claim"

            ),

            TransactionItems(
                "AWNM245TEDRF",
                "12/12/2022",
                "KES 1200",
                "claim"

            ),
            TransactionItems(
                "AWCVA245TEDRF",
                "12/12/2022",
                "KES 2000",
                "claim"

            ),
            TransactionItems(
                "AWEQE345TEDRF",
                "12/12/2022",
                "KES 1000",
                "claim"

            ),
            TransactionItems(
                "AWQE3245TEDRF",
                "12/12/2022",
                "KES 1000",
                "claim"

            ),
            TransactionItems(
                "AWEQE3245T",
                "12/12/2022",
                "KES 1000",
                "claim"

            ),
            TransactionItems(
                "AWEQ4566EDRF",
                "12/12/2022",
                "KES 300",
                "claim"

            ),
            TransactionItems(
                "AWEQE3245TEDRF",
                "12/12/2022",
                "KES 1000",
                "claim"

            ),
            TransactionItems(
                "AWEQE3245TEDRF",
                "12/12/2022",
                "KES 1000",
                "claim"

            ),
            TransactionItems(
                "AWEQE3245TEDRF",
                "12/12/2022",
                "KES 1000",
                "claim"

            )
        )

    }
//    private fun validateFields(): Boolean {
//        val code = binding.edtTransactionCode.text.toString().trim()
//        if (code.isEmpty()) {
//            binding.edtTransactionCode.error = "field is required"
//            return false
//        }
//
//        return true
//    }
}