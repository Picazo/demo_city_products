package com.juliopicazo.data.service.model

data class ProductResponse(
    val products: List<Products>?,
    val total: Int?,
    val skip: Int?,
    val limit : Int?
)

data class Products(
    val id: Int?,
    val title: String?,
    val description: String?,
    val price: Int?,
    val discountPercentage: Double?,
    val rating: Double?,
    val stock: Int?,
    val brand: String?,
    val category: String?,
    val thumbnail: String?,
    val images : List<String>?
)

/* Response product
id":1,
"title":"iPhone 9",
"description":"An apple mobile which is nothing like apple",
"price":549,
"discountPercentage":12.96,
"rating":4.69,
"stock":94,
"brand":"Apple",
"category":"smartphones",
"thumbnail":"https://i.dummyjson.com/data/products/1/thumbnail.jpg",
"images":[
"https://i.dummyjson.com/data/products/1/1.jpg",
"https://i.dummyjson.com/data/products/1/2.jpg",
"https://i.dummyjson.com/data/products/1/3.jpg",
"https://i.dummyjson.com/data/products/1/4.jpg",
"https://i.dummyjson.com/data/products/1/thumbnail.jpg"
]*/