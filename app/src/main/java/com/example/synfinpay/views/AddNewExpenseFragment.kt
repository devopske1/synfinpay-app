package com.example.synfinpay.views

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.MainActivity
import com.example.synfinpay.R
import com.example.synfinpay.databinding.FragmentAddNewExpenseBinding
import com.example.synfinpay.repository.UserRepositoryImpl
import com.example.synfinpay.roomDb.UserDatabase
import com.example.synfinpay.utils.Utils.formatDigits
import com.example.synfinpay.utils.Utils.showCustomDialog
import com.example.synfinpay.viewModel.SynFinPayViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class giAddNewExpenseFragment : Fragment() {
    private lateinit var binding: FragmentAddNewExpenseBinding
    private val userRepository: UserRepositoryImpl by lazy {
        UserRepositoryImpl(UserDatabase.invoke(requireContext()))
    }

    private lateinit var viewModel:SynFinPayViewModel
    private lateinit var calendar: Calendar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNewExpenseBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnAddExpense.setOnClickListener {
            val expenseType = binding.edtExpenseType.text.toString()
            val amount = binding.edtAmount.text.toString()
            val date = binding.edtDate.text.toString()
            if (validateFields()) {

                showCustomDialog()
//                viewModel.saveExpenseData(
//                    ExpenseEntity(
//                        expenseType = expenseType,
//                        amount = amount,
//                        date = date
//                    )
//                )
            } else {
                binding.btnAddExpense.error = "Please fill all fields"
            }
        }


        val expenseAdapter =
            arrayListOf("grapes", "mirinda", "fanta", "coca cola", "sprite", "pepsi")
        binding.edtExpenseType.setAdapter(
            ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                expenseAdapter
            )
        )
        binding.edtExpenseType.setOnClickListener {
            binding.edtExpenseType.showDropDown()
        }
        binding.edtExpenseType.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            binding.edtExpenseType.setText(selectedItem)
        }
        binding.edtDate.setOnClickListener {
            showDatePicker()
        }

    }
    private fun performApiRequest(){

    }

    private fun showDatePicker() {
        calendar = Calendar.getInstance()
        val dialog = DatePickerDialog(requireContext(),
            R.style.DatePickerTheme,
            { _, year, month, day_of_month ->
            calendar[Calendar.YEAR] = year
            calendar[Calendar.MONTH] = month
            calendar[Calendar.DAY_OF_MONTH] = day_of_month
            val myFormat = "yyyy-MM-dd"
            val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
            binding.edtDate.setText(sdf.format(calendar.time))
        }, calendar[Calendar.YEAR], calendar[Calendar.MONTH], calendar[Calendar.DAY_OF_MONTH])
        dialog.datePicker.maxDate = calendar.timeInMillis
        dialog.show()
    }
    private fun validateFields(): Boolean {
        val expenseType = binding.edtExpenseType.text.toString()
        val expenseAmount = formatDigits( binding.edtAmount.text.toString())
        val date = binding.edtDate.text.toString()

        if (expenseType.isNullOrEmpty()) {
            binding.edtExpenseType.error = "Please select expense type"
            return false
        }
        if (expenseAmount.isNullOrEmpty()) {
            binding.edtAmount.error = "Please enter amount"
            return false
        }
        if (date.isNullOrEmpty()) {
            binding.edtDate.error = "Please select date"
            return false
        }
        return true
    }
}