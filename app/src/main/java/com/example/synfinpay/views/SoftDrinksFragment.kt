package com.example.synfinpay.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synfinpay.R
import com.example.synfinpay.adapters.OnSoftDrinkAdapterItemClickedListener
import com.example.synfinpay.adapters.PopularItems
import com.example.synfinpay.adapters.SoftDrinkAdapter
import com.example.synfinpay.adapters.SoftDrinkItems
import com.example.synfinpay.databinding.FragmentSoftDrinksBinding

class SoftDrinksFragment : Fragment() {


private lateinit var binding:FragmentSoftDrinksBinding
private lateinit var softDrinksAdapter: SoftDrinkAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentSoftDrinksBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        initRecyclerView()
        softDrinksAdapter.submitList(softDrinks())

        binding.btnSubmit.setOnClickListener {
            findNavController().navigate(R.id.mycCartFragment2)
        }
    }


    private fun initRecyclerView() {
        softDrinksAdapter = SoftDrinkAdapter(object : OnSoftDrinkAdapterItemClickedListener {
            override fun onItemClicked(view: View, model: SoftDrinkItems) {
                findNavController().navigate(R.id.softDrinksFragment2)

            }

            override fun onItemLongClicked(view: View, softDrink: SoftDrinkItems) {

                // Toggle the isSelected state
                softDrink.isSelected = !softDrink.isSelected

                // Update the background color based on the isSelected state
                softDrinksAdapter.updateItemSelectionBackground(view, softDrink.isSelected)
            }

            override fun onSubtotalUpdated(subtotal: Double) {

            }
        })
        binding.rvSoftDrink.apply {
            adapter = softDrinksAdapter
           layoutManager = LinearLayoutManager(requireContext())
        }

    }




    private fun softDrinks():List<SoftDrinkItems> {
        return listOf(
            SoftDrinkItems(

                R.drawable.mirinda,
                "Mirinda 400ml",
                "$ 163.00",
                "$ 165.00",
                "8% off",
                0,

            ),
            SoftDrinkItems(

                R.drawable.mirinda,
                "Mirinda 400ml",
                "$ 163.00",
                "$ 165.00",
                "8% off",
                0,
            ),
//            SoftDrinkItems(
//
//                R.drawable.mirinda,
//                "Mirinda 400ml",
//                "$ 163.00",
//                "$ 165.00",
//                "20% off",
//                2
//            ),
//                    SoftDrinkItems(
//
//                    R.drawable.mirinda,
//            "Mirinda 400ml",
//            "$ 163.00",
//            "$ 165.00",
//            "20% off",
//            2
//        )
            )

    }
}