package com.juliopicazo.data.service

import android.util.Log
import com.juliopicazo.data.service.api.ProductsAPI
import com.juliopicazo.domain.CoroutineResult
import com.juliopicazo.domain.Product
import com.juliopicazo.domain.ProductRepository
import java.lang.Exception
import javax.inject.Inject

class ProductServiceImpl @Inject constructor(
    private val apiProductsAPI: ProductsAPI
): ProductRepository {
    override suspend fun getProducts(): CoroutineResult<List<Product>> {
        try{
            val callResponse = apiProductsAPI.getProducts()
            val response = callResponse.execute()
            if(response.isSuccessful) response.body()?.let {
                return CoroutineResult.Success(it.mapToLocalProduct() ?: ArrayList())
            }
        }catch (e : Exception){
            Log.e("GOLAZOOO", e.localizedMessage)
        }
        return CoroutineResult.Failed(Exception())
    }

}