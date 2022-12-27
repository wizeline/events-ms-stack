package com.wizeprojects.ellen.orderservice.command

import com.wizeprojects.ellen.orderservice.core.data.OrdersRepository
import com.wizeprojects.ellen.orderservice.core.data.entity.OrderEntity
import com.wizeprojects.ellen.orderservice.core.events.OrderCreatedEvent
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component

@Component
class OrderEventsHandler (private val repository: OrdersRepository) {
    @Throws(Exception::class)
    @EventHandler
    fun on(event: OrderCreatedEvent) {
        val record = OrderEntity(event.orderId,event.productId,event.userId, event.quantity,event.addressId,event.orderStatus)
        try {
            repository.save(record)
        } catch (ex: IllegalArgumentException){
            ex.printStackTrace()
        }
    }
}