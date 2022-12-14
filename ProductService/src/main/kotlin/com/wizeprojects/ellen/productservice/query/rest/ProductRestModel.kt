package com.wizeprojects.ellen.productservice.query.rest

data class ProductRestModel (
    val productId: String,
    val title: String,
    val price: Long,
    val quantity: Int
)