package com.example.synfinpay.utils

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.synfinpay.R
import java.lang.NumberFormatException
import java.text.DecimalFormat

object Utils {

    private var progressD: ProgressDialog? = null

    private var customDialog: Dialog? = null
    fun Fragment.setStatusBarColor() {
        activity?.window?.statusBarColor =
            resources.getColor(com.example.synfinpay.R.color.secondary)
    }

    fun Fragment.setStatusBarColorBlue() {
        activity?.window?.statusBarColor =
            resources.getColor(com.example.synfinpay.R.color.primary)
    }

    fun Fragment.setStatusBarColorWhite() {
        activity?.window?.statusBarColor =
            resources.getColor(com.example.synfinpay.R.color.white)
    }

    fun Fragment.showCustomDialog(
//        expenseType: String, amount: String, date: String
    ) {

        customDialog = Dialog(requireContext())
        customDialog?.setContentView(R.layout.layout_confirm_dialog)
        // Set any other properties you need for your dialog
        // For example, setting its size, position, or making it not cancelable
        // ...

        // Initialize your buttons and set their click listeners
        val cancelButton = customDialog?.findViewById<Button>(R.id.button_cancel)
        val confirmButton = customDialog?.findViewById<Button>(R.id.button_confirm)

        cancelButton?.setOnClickListener {
            customDialog?.dismiss()
        }

        confirmButton?.setOnClickListener {
            showProgressDialog()

            Handler().postDelayed({
                dismissProgressDialog()
                showCustomSuccessDialog()
            }, 2000)
            customDialog?.dismiss()


        }
//        customDialog?.findViewById<TextView>(R.id.edtExpenseType)?.text = expenseType
//        customDialog?.findViewById<TextView>(R.id.edtAmount)?.text = amount
//        customDialog?.findViewById<TextView>(R.id.edtDate)?.text = date


        customDialog?.show()
    }

    fun Fragment.showStockCustomDialog() {
        customDialog = Dialog(requireContext())
        customDialog?.setContentView(R.layout.layout_confirm_dialog)
        // Set any other properties you need for your dialog
        // For example, setting its size, position, or making it not cancelable
        // ...

        // Initialize your buttons and set their click listeners
        val cancelButton = customDialog?.findViewById<Button>(R.id.button_cancel)
        val confirmButton = customDialog?.findViewById<Button>(R.id.button_confirm)

        cancelButton?.setOnClickListener {
            customDialog?.dismiss()
        }

        confirmButton?.setOnClickListener {
            showStockProgressDialog()

            Handler().postDelayed({
                dismissProgressDialog()
                showStockCustomSuccessDialog()
            }, 2000)
            customDialog?.dismiss()


        }


        customDialog?.show()
    }

    fun Fragment.showProgressDialog() {
        progressD = ProgressDialog(context)
        progressD?.setMessage("We are processing your request Please wait.....")
        progressD?.setCancelable(false)
        progressD?.show()
    }

    fun Fragment.showStockProgressDialog() {
        progressD = ProgressDialog(context)
        progressD?.setMessage("We are processing your request Please wait.....")
        progressD?.setCancelable(false)
        progressD?.show()
    }

    fun Fragment.dismissProgressDialog() {
        progressD?.dismiss()
        progressD = null
    }

    fun Fragment.showCustomSuccessDialog() {
        customDialog = Dialog(requireContext())
        customDialog?.setContentView(R.layout.dialog_custom_sucess_layout)
        // Set any other properties you need for your dialog
        // For example, setting its size, position, or making it not cancelable
        // ...

        // Initialize your buttons and set their click listeners
        val dismissButton = customDialog?.findViewById<Button>(R.id.btnConfirm)


        dismissButton?.setOnClickListener {
            customDialog?.dismiss()
            findNavController().navigate(R.id.expenseRecordFragment2)
        }




        customDialog?.show()
    }

    fun Fragment.showStockCustomSuccessDialog() {
        customDialog = Dialog(requireContext())
        customDialog?.setContentView(R.layout.dialog_custom_sucess_layout)
        // Set any other properties you need for your dialog
        // For example, setting its size, position, or making it not cancelable
        // ...

        // Initialize your buttons and set their click listeners
        val dismissButton = customDialog?.findViewById<Button>(R.id.btnConfirm)


        dismissButton?.setOnClickListener {
            customDialog?.dismiss()
            findNavController().navigate(R.id.stockInFragment2)
        }




        customDialog?.show()
    }

    fun formatDigits(wholeNumber: String): String {
        var number: Double = 0.0
        val formatter: DecimalFormat
        try {
            number = wholeNumber.toDouble()
        } catch (e: NumberFormatException) {
            return wholeNumber
        }
        if (number == 0.00) {
            formatter = DecimalFormat("0.00")
        } else if (number == "0".toDouble()) {
            formatter = DecimalFormat("0.##")
        } else {
            formatter = DecimalFormat("#,###.00")
        }

        return formatter.format(number)
    }
}