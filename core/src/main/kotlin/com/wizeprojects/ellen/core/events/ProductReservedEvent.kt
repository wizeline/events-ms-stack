package com.wizeprojects.ellen.core.events

data class ProductReservedEvent (
    val productId: String,
    val quantity: Int,
    val orderId: String,
    val userId: String
)