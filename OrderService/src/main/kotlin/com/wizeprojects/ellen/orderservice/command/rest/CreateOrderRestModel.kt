package com.wizeprojects.ellen.orderservice.command.rest

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class CreateOrderRestModel (

    @NotBlank(message = "Product id is required")
    val productId: String,
    @Min(value=1, message = "Quantity should be greater than 1")
    @Max(value=10000, message = "Quantity should be lower than 10000")
    val quantity: Int,
    @NotBlank(message="Address is required")
    val addressId: String,
)

