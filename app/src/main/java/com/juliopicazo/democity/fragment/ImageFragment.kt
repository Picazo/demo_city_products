package com.juliopicazo.democity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.juliopicazo.democity.databinding.FragmentImageBinding

class ImageFragment : Fragment(){

    private lateinit var binding: FragmentImageBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textTitle = arguments?.getString("title")
        val imageUrl = arguments?.getString("image")
        val textDescription = arguments?.getString("description")

        binding.apply {
            tvTitle.text = textTitle.toString()
            Glide.with(requireContext())
                .load(imageUrl)
                .into(ivProduct)
            tvDescription.text = textDescription.toString()
        }

    }

    companion object{
        fun newInstance(title: String?, image: String?, description: String?): ImageFragment? {
            val fragment = ImageFragment()
            val args = Bundle()
            args.putString("title", title)
            args.putString("image", image)
            args.putString("description", description)
            fragment.arguments = args
            return fragment
        }
    }

}