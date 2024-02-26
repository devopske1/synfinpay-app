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
import com.example.synfinpay.adapters.ExpenseAdapter
import com.example.synfinpay.adapters.Expenses
import com.example.synfinpay.databinding.FragmentExpenseRecordBinding
import com.example.synfinpay.viewModel.SynFinPayViewModel


class ExpenseRecordFragment : Fragment() {

    private lateinit var viewModel: SynFinPayViewModel
    private lateinit var binding: FragmentExpenseRecordBinding
    private lateinit var expenseRecordAdapter: ExpenseAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentExpenseRecordBinding.inflate(layoutInflater)
        return binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addNewExpenseFragment2)
        }
        initRecyclerView()
        expenseRecordAdapter.submitList(dummyExpensesRecords())
//        viewModel.getExpenseData { expenses ->
//            expenseRecordAdapter.submitList(expenses)
//        }


    }

    private fun initRecyclerView() {
        expenseRecordAdapter = ExpenseAdapter()
        binding.rvTithePaymentsItems.apply {
            adapter = expenseRecordAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }


    }

    private fun dummyExpensesRecords(): List<Expenses> {
        return listOf(
            Expenses(
                "Apples",
                "Kes 20000",
                "12/09/2023",
            ),
            Expenses(
                "Apples",
                "Kes 20000",
                "12/09/2023",
            ),
            Expenses(
                "Apples",
                "Kes 20000",
                "12/09/2023",
            ),
            Expenses(
                "Apples",
                "Kes 20000",
                "12/09/2023",
            ),
            Expenses(
                "Apples",
                "Kes 20000",
                "12/09/2023",
            ),
            Expenses(
                "Apples",
                "Kes 20000",
                "12/09/2023",
            ),
            Expenses(
                "Apples",
                "Kes 20000",
                "12/09/2023",
            ),


            )


    }

}