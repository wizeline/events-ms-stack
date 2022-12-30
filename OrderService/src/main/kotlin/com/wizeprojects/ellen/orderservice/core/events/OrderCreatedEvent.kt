package com.wizeprojects.ellen.orderservice.core.events

import com.wizeprojects.ellen.orderservice.core.model.OrderStatus

data class OrderCreatedEvent (
        val orderId: String,
        val userId: String,
        val productId: String,
        val quantity: Int,
        val addressId: String,
        val orderStatus: OrderStatus
)