package com.wizeprojects.ellen.core.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier

data class ReserveProductCommand(
    @TargetAggregateIdentifier
    val productId: String,
    val quantity: Int,
    val orderId: String,
    val userId: String
)