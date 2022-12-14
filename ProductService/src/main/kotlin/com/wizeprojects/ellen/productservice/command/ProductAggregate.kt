package com.wizeprojects.ellen.productservice.command

import com.wizeprojects.ellen.productservice.core.events.ProductCreatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateCreationPolicy
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.modelling.command.CreationPolicy

import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class ProductAggregate {

    @AggregateIdentifier
    private lateinit var productId: String
    private lateinit var title: String
    private var price: Long = 0
    private var quantity: Int = 0

    fun ProductAggregate() {}

    @CommandHandler
    @CreationPolicy(AggregateCreationPolicy.ALWAYS)
    fun ProductAggregate(createProductCommand: CreateProductCommand) {
        if(createProductCommand.price <= 0) {
            throw IllegalArgumentException("Price must be greater than zero")
        }

        if(createProductCommand.title.isNullOrEmpty()) {
            throw IllegalArgumentException("Title cannot be empty")
        }

        //that will dispatch the event to all event handlers inside this aggregate
        AggregateLifecycle.apply(ProductCreatedEvent(
            createProductCommand.productId,
            createProductCommand.title,
            createProductCommand.price,
            createProductCommand.quantity
        ))
    }

    @EventSourcingHandler
    fun on(productCreatedEvent: ProductCreatedEvent) {
        this.productId = productCreatedEvent.productId
        this.title = productCreatedEvent.title
        this.price = productCreatedEvent.price
        this.quantity = productCreatedEvent.quantity
    }
}