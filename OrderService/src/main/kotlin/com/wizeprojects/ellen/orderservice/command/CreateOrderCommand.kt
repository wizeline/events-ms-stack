package com.wizeprojects.ellen.orderservice.command

import com.wizeprojects.ellen.orderservice.core.OrderStatus
import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

data class CreateOrderCommand (
    val productId: String,
    val quantity: Int,
    val addressId: String,
    val orderStatus: OrderStatus,
    val userId: String = "27b95829-4f3f-4ddf-8983-151ba010e35b",
    @TargetAggregateIdentifier val orderId: String = UUID.randomUUID().toString()
)