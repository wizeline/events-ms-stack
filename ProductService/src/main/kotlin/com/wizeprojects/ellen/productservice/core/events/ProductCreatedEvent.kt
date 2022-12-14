package com.wizeprojects.ellen.productservice.core.events

data class ProductCreatedEvent (
    val productId: String,
    val title: String,
    val price: Long,
    val quantity: Int
)