package com.example.synfinpay.views

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synfinpay.R
import com.example.synfinpay.adapters.OnSoftDrinkAdapterItemClickedListener
import com.example.synfinpay.adapters.SoftDrinkAdapter
import com.example.synfinpay.adapters.SoftDrinkItems
import com.example.synfinpay.databinding.FragmentCharlesMwambireBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class CharlesMwambireFragment : Fragment() {
    private val softDrinkList = mutableListOf<SoftDrinkItems>()
    private var selectedItem: SoftDrinkItems? = null
    private lateinit var binding: FragmentCharlesMwambireBinding
    private lateinit var softDrinkAdapter: SoftDrinkAdapter
    private var selectedCard: CardView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharlesMwambireBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

        initRecyclerView()
        softDrinkAdapter.submitList(dummySoftDrinks())
        binding.btnCheckOut.setOnClickListener {
            showBottomSheetDialog()
        }

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }


    }






    private fun initRecyclerView() {
        softDrinkAdapter = SoftDrinkAdapter(
            object : OnSoftDrinkAdapterItemClickedListener {
                override fun onItemClicked(view: View, model: SoftDrinkItems) {
                }

                override fun onItemLongClicked(view: View, softDrink: SoftDrinkItems) {
                    binding.tvRemoveItems.visibility = View.VISIBLE

                    // Toggle the isSelected state
                    softDrink.isSelected = !softDrink.isSelected

                    // Update the background color based on the isSelected state
                    softDrinkAdapter.updateItemSelectionBackground(view, softDrink.isSelected)

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
    }

    private fun dummySoftDrinks(): List<SoftDrinkItems> {

        val list = mutableListOf<SoftDrinkItems>()
        list.add(
            SoftDrinkItems(
                R.drawable.mirinda,
                "Mirinda Pepsi 400ML",
                "\$ 164.00",
                "$ 164.00",

                "8% off",
                0,

            ))

        list.add(
            SoftDrinkItems(
                R.drawable.mirinda,
                "Mirinda Pepsi 400ML",
                "\$ 164.00",
                "$ 164.00",
                "8% off",
                0,

            ))



          return list

    }

    private fun showBottomSheetDialog() {
        // Create the BottomSheetDialog
        val bottomSheetDialog = BottomSheetDialog(requireContext())

        // Inflate your layout for the dialog
        val view = layoutInflater.inflate(R.layout.fragment_select_mode_of_payment, null)

        // Set the view for the dialog
        bottomSheetDialog.setContentView(view)
        val buttonContinue = view.findViewById<Button>(R.id.btnContinue)
        val cardMobileMoney = view.findViewById<CardView>(R.id.card)
        val cardCash = view.findViewById<CardView>(R.id.card_cash)

        cardMobileMoney.setOnClickListener {
            selectCard(cardMobileMoney)
            buttonContinue.isEnabled = true
        }

        cardCash.setOnClickListener {
            selectCard(cardCash)
            buttonContinue.isEnabled = true
        }

        buttonContinue.setOnClickListener {
            selectedCard?.let {
                val fragment = when (it.id) {
                    R.id.card -> MobileMoneyFragment()
                    R.id.card_cash -> TransactionsFragment()
                    else -> null
                }

                fragment?.let {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, it)
                        .commit()
                    bottomSheetDialog.dismiss()
                }
            }
        }

        bottomSheetDialog.show()
    }

    private fun selectCard(card: CardView) {
        selectedCard?.setCardBackgroundColor(Color.WHITE)
        card.setCardBackgroundColor(Color.LTGRAY)
        selectedCard = card


    }




}




