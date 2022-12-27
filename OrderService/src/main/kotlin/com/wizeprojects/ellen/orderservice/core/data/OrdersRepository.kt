package com.wizeprojects.ellen.orderservice.core.data

import com.wizeprojects.ellen.orderservice.core.data.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrdersRepository : JpaRepository<OrderEntity, String> {
}