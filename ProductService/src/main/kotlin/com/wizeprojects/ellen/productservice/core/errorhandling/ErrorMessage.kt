package com.wizeprojects.ellen.productservice.core.errorhandling

import java.util.Date

data class ErrorMessage (
    val timestamp: Date,
    val message: String?
)