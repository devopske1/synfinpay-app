package com.example.synfinpay.views

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.MainActivity
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentAddStockBinding
import com.example.synfinpay.utils.Utils.dismissProgressDialog
import com.example.synfinpay.utils.Utils.showCustomDialog
import com.example.synfinpay.utils.Utils.showProgressDialog
import com.example.synfinpay.viewModel.SynFinPayViewModel


class AddStockFragment : Fragment() {
    private lateinit var binding: FragmentAddStockBinding

private lateinit var  viewModel:SynFinPayViewModel
    private var progressD: ProgressDialog? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddStockBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnAddStock.setOnClickListener {
            showProgressDialog()

            Handler().postDelayed({
                dismissProgressDialog()
                findNavController().navigate(R.id.stockFragment)
            }, 2000)
        }



    viewModel = (activity as MainActivity).viewModel

    binding.back.setOnClickListener {
        findNavController().navigateUp()
    }
    binding.btnAddStock.setOnClickListener {
        val inventory = binding.edtInventory.text.toString()
        val quantity = binding.edtQuantity.text.toString()
        val total = binding.edtTotalValue.text.toString()
        if (validateFields()) {
         showCustomDialog()
//            viewModel.saveStockData(
//              StockEntity(
//                    inventory = inventory,
//                    quantity = quantity,
//                    total= total
//
//                )
//            )
        } else {
            binding.btnAddStock
                .error = "Please fill all fields"
        }
    }


    val expenseAdapter =
        arrayListOf("grapes", "mirinda", "fanta", "coca cola", "sprite", "pepsi")
    binding.edtInventory.setAdapter(
    ArrayAdapter(
    requireContext(),
    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
    expenseAdapter
    )
    )

        binding.edtInventory.setOnClickListener {
            binding.edtInventory.showDropDown()
        }
    binding.edtInventory.setOnItemClickListener { parent, view, position, id ->
        val selectedItem = parent.getItemAtPosition(position).toString()
        binding.edtInventory.setText(selectedItem)
    }

}


private fun validateFields(): Boolean {
    val expenseType = binding.edtInventory.text.toString()
    val expenseAmount = binding.edtQuantity.text.toString()
    val date = binding.edtTotalValue.text.toString()

    if (expenseType.isNullOrEmpty()) {
        binding.edtInventory.error = "Please select product"
        return false
    }
    if (expenseAmount.isNullOrEmpty()) {
        binding.edtQuantity.error = "Please enter Quantity"
        return false
    }
    if (date.isNullOrEmpty()) {
        binding.edtTotalValue.error = "Please select Total Value"
        return false
    }
    return true
}

}