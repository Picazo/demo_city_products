package com.juliopicazo.data.service.api

import com.juliopicazo.data.service.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductsAPI {

    @GET("/products")
    fun getProducts(): Call<ProductResponse>

}