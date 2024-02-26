package com.example.synfinpay.views

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synfinpay.R
import com.example.synfinpay.adapters.OnSoftDrinkAdapterItemClickedListener
import com.example.synfinpay.adapters.SelectItems
import com.example.synfinpay.adapters.SoftDrinkAdapter
import com.example.synfinpay.adapters.SoftDrinkItems
import com.example.synfinpay.databinding.FragmentOrderBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class OrderFragment : Fragment() {
    private var selectedItem: SoftDrinkItems? = null
    private lateinit var binding: FragmentOrderBinding
    private lateinit var softDrinkAdapter: SoftDrinkAdapter
    private var selectedSoftDrink: SoftDrinkItems? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        softDrinkAdapter.submitList(dummySoftDrinks())
        binding.btnCheckOut.setOnClickListener {
            showBottomSheetDialog()
        }

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        val totalAmount = softDrinkAdapter.calculateTotalAmount()
        binding.tvPrice.text = totalAmount.toString()

        binding.tvRemoveItems.setOnClickListener {
            selectedSoftDrink = softDrinkAdapter.getSelectedSoftDrink()
            if (selectedSoftDrink != null) {
                softDrinkAdapter.removeItem(selectedSoftDrink!!)
                binding.tvRemoveItems.isEnabled = true

                val totalAmount = softDrinkAdapter.calculateTotalAmount()
                binding.tvPrice.text =  totalAmount.toString()
            }

        }

    }

    private fun getSelectedSoftDrink(): SoftDrinkItems? {
        return selectedItem
    }

    private fun initRecyclerView() {
        softDrinkAdapter = SoftDrinkAdapter(
            object : OnSoftDrinkAdapterItemClickedListener {
                override fun onItemClicked(view: View, model: SoftDrinkItems) {

                }

                @SuppressLint("ResourceAsColor")
                override fun onItemLongClicked(view: View, softDrink: SoftDrinkItems) {

                    val cardView = view.findViewById<CardView>(R.id.cardView)
                    cardView.setBackgroundColor(R.color.sfb_blue_primary)
                    selectedItem = softDrink
                    binding.tvRemoveItems.visibility = View.VISIBLE



                }

                override fun onSubtotalUpdated(subtotal: Double) {
                    binding.tvPrice.text = subtotal.toString()
                }
            }
        )

        binding.recycler.apply {
            adapter = softDrinkAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        val initialTotalAmount = softDrinkAdapter.calculateTotalAmount()
        binding.tvPrice.text = initialTotalAmount.toString()
    }

    private fun dummySoftDrinks(): List<SoftDrinkItems> {
        return listOf(
            SoftDrinkItems(
                R.drawable.mirinda,
                "Mirinda Pepsi 400ML",
                " 164.00",
                "164.00",
                "8% off",


            ),

            SoftDrinkItems(
                R.drawable.mirinda,
                "Mirinda Pepsi 400ML",
                "164.00",
                "164.00",
                "8% off",

            ),
            SoftDrinkItems(
                R.drawable.mirinda,
                "Mirinda Pepsi 400ML",
                "164.00",
                "164.00",
                "8% off",


            ),


        )


    }

    private fun showBottomSheetDialog() {
        // Create the BottomSheetDialog
        val bottomSheetDialog = BottomSheetDialog(requireContext())

        // Inflate your layout for the dialog
        val view = layoutInflater.inflate(R.layout.fragment_select_mode_of_payment, null)

        // Set the view for the dialog
        bottomSheetDialog.setContentView(view)

        // Set any other properties for the dialog
        // For example, you can set the behavior, animation, etc.
        // bottomSheetDialog.behavior.peekHeight = 500 // Set the initial height

        // Initialize your views and set their click listeners
        val buttonCheckOut = view.findViewById<Button>(R.id.btnContinue)
        val cardMobileMoney = view.findViewById<CardView>(R.id.card)
        val cardCash = view.findViewById<CardView>(R.id.card_cash)

        // Set click listener for the "Check Out" button
        buttonCheckOut.setOnClickListener {
            // Add your logic for the "Check Out" button here
            // ...
            bottomSheetDialog.dismiss() // Dismiss the dialog after performing the action
        }

        // Set click listener for the "Mobile Money" card
        cardMobileMoney.setOnClickListener {
            findNavController().navigate(R.id.mobileMoneyFragment2)
            bottomSheetDialog.dismiss() // Dismiss the dialog after performing the action
        }

        // Set click listener for the "Cash" card
        cardCash.setOnClickListener {
            findNavController().navigate(R.id.mobileMoneyFragment2)
            bottomSheetDialog.dismiss() // Dismiss the dialog after performing the action
        }

        // Show the BottomSheetDialog
        bottomSheetDialog.show()
    }
}