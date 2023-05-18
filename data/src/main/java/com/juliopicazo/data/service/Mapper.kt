package com.juliopicazo.data.service

import com.juliopicazo.data.service.model.ProductResponse
import com.juliopicazo.data.service.model.Products
import com.juliopicazo.domain.Product


fun ProductResponse.mapToLocalProduct() : List<Product>? = products?.map { it.mapToLocalProducts() }

private fun Products.mapToLocalProducts() =
    Product(
        title = title.toString(),
        description = description.toString(),
        image = thumbnail.toString(),
        price = price.toString()
    )
