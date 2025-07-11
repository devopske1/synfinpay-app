package com.example.synfinpay.views

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synfinpay.R
import com.example.synfinpay.adapters.OnSelectOrderAdapterItemClickedListener
import com.example.synfinpay.adapters.SelectItems
import com.example.synfinpay.adapters.SelectOrderAdapter
import com.example.synfinpay.databinding.FragmentRunningOrderBinding


class RunningOrderFragment : Fragment() {
private lateinit var selectOrderAdapter: SelectOrderAdapter
private lateinit var binding: FragmentRunningOrderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentRunningOrderBinding.inflate(layoutInflater)
        return binding.root
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        initRecyclerView()
        selectOrderAdapter.submitList(dummyRunningOrder())

        binding.btnClosedOrder.setOnClickListener {
        binding.runningOrder.isEnabled= false
            binding.runningOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.button_background))
               binding.btnClosedOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.button_blue_bcakground))
           findNavController().navigate(R.id.closedOrderFragment)
        }

        binding.runningOrder.setOnClickListener {
            binding.btnClosedOrder.isEnabled= false
            binding.btnClosedOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.button_background))
            binding.runningOrder.setBackgroundDrawable(resources.getDrawable(R.drawable.button_blue_bcakground))
            initRecyclerView()
            selectOrderAdapter.submitList(dummyRunningOrder())
        }
    }

    private fun initRecyclerView(){
        selectOrderAdapter = SelectOrderAdapter(object: OnSelectOrderAdapterItemClickedListener {
            override fun onItemClicked(view: View, select: SelectItems) {
                findNavController().navigate(R.id.orderFragment2)
            }
        }
        )

        binding.recyclerClosedOrder.apply{
            adapter = selectOrderAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }



    }

    private fun dummyRunningOrder(): List<SelectItems> {
        return listOf(
            SelectItems(
                "Order No: 002M",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),
            SelectItems(
                "Order No: 002M",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),
            SelectItems(
                "Order No: 002M",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),

            SelectItems(
                "Order No: 002M",
                "Date: 12/12/2020",
                "Total: Ksh 2000",
                2

            ),

            )


    }

}