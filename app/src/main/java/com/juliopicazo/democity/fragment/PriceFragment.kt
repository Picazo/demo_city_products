package com.juliopicazo.democity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.juliopicazo.democity.databinding.FragmentImageBinding
import com.juliopicazo.democity.databinding.FragmentPriceBinding

class PriceFragment : Fragment(){

    private lateinit var binding: FragmentPriceBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPriceBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val price = arguments?.getString("price")

        binding.apply {
            tvPrice.text = "$ ${price.toString()}"
            btnBack.setOnClickListener {
                requireActivity().finish()
            }
        }

    }

    companion object{
        fun newInstance(price: String): PriceFragment? {
            val fragment = PriceFragment()
            val args = Bundle()
            args.putString("price", price)
            fragment.arguments = args
            return fragment
        }
    }

}