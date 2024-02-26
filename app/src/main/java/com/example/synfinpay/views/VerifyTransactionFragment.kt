package com.example.synfinpay.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synfinpay.R
import com.example.synfinpay.adapters.OnTransactionAdapterItemClicked
import com.example.synfinpay.adapters.TransactionAdapter
import com.example.synfinpay.adapters.TransactionItems
import com.example.synfinpay.databinding.FragmentVerifyTransactionBinding


class VerifyTransactionFragment : Fragment() {
private lateinit var binding: FragmentVerifyTransactionBinding
private lateinit var transactionsAdapter:TransactionAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVerifyTransactionBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        initRecyclerView()
        transactionsAdapter.submitList(dummyTransactions())



        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                val filteredList = dummyTransactions().filter {
                    it.category.contains(p0.toString())
                }
                transactionsAdapter.submitList(filteredList)
            }

        })

    }



    private fun initRecyclerView(){
        transactionsAdapter= TransactionAdapter(object: OnTransactionAdapterItemClicked {
            override fun onTransactionItemClicked(transactionItems: TransactionItems) {
                findNavController().navigate(R.id.selectOrderFragment2)
            }

        })
        binding.rvTransactions.apply {
            adapter =transactionsAdapter
            layoutManager= LinearLayoutManager(requireContext())
        }

    }

    private fun dummyTransactions():List<TransactionItems>{
        return listOf(
            TransactionItems(
                "AWEQE3245TEDRF",
                "12/12/2022",
                "KES 800",
                "claim"


            )
            ,

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


}