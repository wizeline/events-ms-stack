package com.wizeprojects.ellen.orderservice.command

import com.wizeprojects.ellen.orderservice.core.OrderStatus
import com.wizeprojects.ellen.orderservice.core.events.OrderCreatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class OrderAggregate {

    @AggregateIdentifier
    private lateinit var orderId: String
    private lateinit var userId: String
    private lateinit var productId: String
    private var quantity: Int = 0
    private lateinit var addressId: String
    private lateinit var orderStatus: OrderStatus


    @CommandHandler
    constructor(command: CreateOrderCommand) {
        AggregateLifecycle
            .apply(OrderCreatedEvent(command.orderId, command.userId, command.productId, command.quantity, command.addressId, command.orderStatus))
    }

    @EventSourcingHandler
    fun handle(event: OrderCreatedEvent) {
        orderId = event.orderId
        userId = event.userId
        productId = event.productId
        quantity = event.quantity
        addressId = event.addressId
        orderStatus = event.orderStatus
    }
}