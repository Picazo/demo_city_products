package com.juliopicazo.domain

interface ProductRepository
{
    suspend fun getProducts(): CoroutineResult<List<Product>>
}