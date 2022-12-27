package com.wizeprojects.ellen.orderservice.core.data.entity

import com.wizeprojects.ellen.orderservice.core.OrderStatus
import javax.persistence.*

@Entity
@Table(name="orders")
data class OrderEntity (
    @Id
    @Column(unique = true)
    val orderId: String,
    val productId: String,
    val userId: String,
    val quantity: Int,
    val addressId: String,
    @Enumerated(EnumType.STRING)
    val orderStatus: OrderStatus
)
