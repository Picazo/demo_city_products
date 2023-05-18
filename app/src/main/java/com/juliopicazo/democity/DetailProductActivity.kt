package com.juliopicazo.democity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juliopicazo.democity.adapter.ProductAdapter
import com.juliopicazo.democity.databinding.ActivityMainBinding
import com.juliopicazo.democity.viewmodel.ProductViewModel
import com.juliopicazo.democity.viewmodel.ProductViewModel.ProductData
import com.juliopicazo.domain.Product
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.juliopicazo.democity.databinding.ActivityDetailBinding
import com.juliopicazo.democity.fragment.ImageFragment
import com.juliopicazo.democity.fragment.PriceFragment


@AndroidEntryPoint
class DetailProductActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetailBinding

    val product: Product by lazy {
        Gson().fromJson(intent.extras?.getString("product"), Product::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        sendDataViews()
    }

    private fun sendDataViews(){
        val fragmentImage = ImageFragment.newInstance(
            product.title,
            product.image,
            product.description
        )

        fragmentImage?.let { _fragment
            -> loadFragmentImage(_fragment)
        }

        val fragmentPrice = PriceFragment.newInstance(product.price)
        fragmentPrice?.let { _fragment
            -> loadFragmentPrice(_fragment)
        }

    }

    private fun loadFragmentImage(fragment: Fragment) {
        // load fragment
        val fragmentImage = supportFragmentManager.beginTransaction()
        fragmentImage.replace(R.id.fragmentPhoto, fragment)
        fragmentImage.addToBackStack(null)
        fragmentImage.commit()
    }

    private fun loadFragmentPrice(fragment: Fragment) {
        // load fragment
        val fragmentPrice = supportFragmentManager.beginTransaction()
        fragmentPrice.replace(R.id.fragmentPrice, fragment)
        fragmentPrice.addToBackStack(null)
        fragmentPrice.commit()
    }

}