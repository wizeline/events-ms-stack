package com.wizeprojects.ellen.productservice.command.rest

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class CreateProductRestModel (
    @NotBlank(message = "Product title is required")
    val title: String,
    @Min(value=1, message = "Price should be greater than 1")
    val price: Long,
    @Min(value=1, message = "Quantity should be greater than 1")
    @Max(value=10000, message = "Quantity should be lower than 10000")
    val quantity: Int
)