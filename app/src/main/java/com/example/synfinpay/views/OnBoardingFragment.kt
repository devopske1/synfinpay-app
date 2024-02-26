package com.example.synfinpay.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.synfinpay.R
import com.example.synfinpay.adapters.OnBoardingAdapter
import com.example.synfinpay.databinding.FragmentOnboardingBinding
import com.example.synfinpay.utils.AutoSlideAdvertisement
import com.example.synfinpay.utils.Utils.setStatusBarColor
import com.example.synfinpay.utils.Utils.setStatusBarColorBlue


class OnBoardingFragment :androidx.fragment.app.Fragment() {
    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentOnboardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setStatusBarColor()


        binding.btnNext.setOnClickListener {
            findNavController()
                .navigate(R.id.signUpFragment)
        }

        binding.btnSkip.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }

        binding.btnSignUp.setOnClickListener {
            findNavController()
                .navigate(R.id.signUpFragment)
        }

        binding.btnSignIn.setOnClickListener {
            findNavController().navigate(R.id.signInFragment)
        }

        loadSliders()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    private fun loadSliders() {
        val onBoardingAdapter =
            OnBoardingAdapter(
                requireContext()
            )
        binding.pager.adapter = onBoardingAdapter
        binding.tabDots.setupWithViewPager(binding.pager, true)
        onBoardingAdapter.notifyDataSetChanged()

        binding.pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                when (position) {
                    0 -> {
                        binding.tvSliderTitle.setText("Welcome to SynfinPay")
                        binding.tvSliderDescr.setText("Our community of creatives is ready for your next big thing. Let’s go creatively wild!")
                        binding.btnSignIn.visibility= View.INVISIBLE
                        binding.btnSignUp.visibility =View.INVISIBLE
                        binding.btnNext.visibility =View.VISIBLE
                        binding.btnSkip.visibility =View.VISIBLE
                    }
                    1 -> {
                        binding.tvSliderTitle.setText("Design Templates are Simple and Easy")
                        binding.tvSliderDescr.setText("Create a unique emotional story that describes better than words")
                        binding.tvSliderDescr.setText("Our community of creatives is ready for your next big thing. Let’s go creatively wild!")
                        binding.btnSignIn.visibility= View.INVISIBLE
                        binding.btnSignUp.visibility =View.INVISIBLE
                        binding.btnNext.visibility =View.VISIBLE
                        binding.btnSkip.visibility =View.VISIBLE
                    }
                    else -> {
                        binding.tvSliderTitle.setText("Lorem ipsum dolor sit amet consectetur.")
                        binding.tvSliderDescr.setText("Create a unique emotional story thatdescribes better than words")
                        binding.btnSignIn.visibility= View.VISIBLE
                        binding.btnSignUp.visibility =View.VISIBLE
                        binding.btnNext.visibility =View.INVISIBLE
                        binding.btnSkip.visibility =View.INVISIBLE

                    }
                }
            }

            override fun onPageSelected(position: Int) {


            }
        })

        val autoPlay = AutoSlideAdvertisement()
        autoPlay.autoPlayAdvertisement(binding.pager)

    }


}



