package com.wizeprojects.ellen.productservice.command
import org.axonframework.modelling.command.TargetAggregateIdentifier

data class CreateProductCommand (
    @TargetAggregateIdentifier val productId: String,
    val title: String,
    val price: Long,
    val quantity: Int
)