package com.wizeprojects.ellen.orderservice.core.events

import com.wizeprojects.ellen.orderservice.core.model.OrderStatus
import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

data class OrderCreatedEvent (
        val orderId: String,
        val userId: String,
        val productId: String,
        val quantity: Int,
        val addressId: String,
        val orderStatus: OrderStatus
)