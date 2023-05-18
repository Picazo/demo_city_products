package com.juliopicazo.democity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juliopicazo.democity.adapter.ProductAdapter.OnItemClicked
import com.juliopicazo.democity.databinding.ItemProductosBinding
import com.juliopicazo.domain.Product

class ProductAdapter (
    private val productList : List<Product>,
    var listener : OnItemClicked
): RecyclerView.Adapter<ProductsViewHolder>()

{
    interface OnItemClicked {
        fun onItemClicked(product: Product)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemProductosBinding.inflate(inflate, parent, false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val productItem : Product = productList[position]
        holder.bind(productItem, listener)
    }

    override fun getItemCount(): Int = productList.size


}

class ProductsViewHolder(private val binding : ItemProductosBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(product: Product, listener: OnItemClicked){
        binding.apply {
            tvTitle.text = "Nombre: ${product.title}"
            tvDescription.text = product.description
            tvPrice.text = "Precio: ${product.price}"

            cvProductos.setOnClickListener {
                listener.onItemClicked(product)
            }
        }

    }

}