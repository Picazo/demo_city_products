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
import com.google.gson.Gson


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ProductAdapter.OnItemClicked {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.state.observe({lifecycle}, ::updateUI)

    }

    override fun onResume() {
        super.onResume()

        viewModel.getProducts()
    }

    private fun updateUI(productData: ProductData){
        if(!productData.products.isNullOrEmpty()){
            binding.apply {
                rvProductos.apply {
                    adapter = ProductAdapter(productData.products, this@MainActivity)
                    setHasFixedSize(true)
                }
            }
        }
    }

    override fun onItemClicked(product: Product) {
        val intent = Intent(this@MainActivity, DetailProductActivity::class.java)
        intent.putExtra("product", Gson().toJson(product))
        startActivity(intent)
    }
}