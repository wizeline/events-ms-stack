package com.wizeprojects.ellen.productservice.core.errorhandling

import org.axonframework.commandhandling.CommandExecutionException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.util.*
import kotlin.IllegalStateException

@ControllerAdvice
class ProductsServiceErrorHandler {

    @ExceptionHandler(value=[(IllegalStateException::class)])
    fun handleIllegalStateException(ex: IllegalStateException, request: WebRequest): ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage(Date(), ex.message), HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value=[(Exception::class)])
    fun handleOtherExceptions(ex: Exception, request: WebRequest): ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage(Date(), ex.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }
    @ExceptionHandler(value=[(CommandExecutionException::class)])
    fun handleCommandExecutionException(ex: CommandExecutionException, request: WebRequest): ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage(Date(), ex.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}