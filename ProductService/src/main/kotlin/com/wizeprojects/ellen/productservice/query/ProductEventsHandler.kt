package com.wizeprojects.ellen.productservice.query

import com.wizeprojects.ellen.productservice.core.data.entity.ProductEntity
import com.wizeprojects.ellen.productservice.core.data.ProductsRepository
import com.wizeprojects.ellen.productservice.core.events.ProductCreatedEvent
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ExceptionHandler


@Component
@ProcessingGroup("product-group")
class ProductEventsHandler (private val repository: ProductsRepository) {
    @ExceptionHandler(Exception::class)
    fun handle(exception: Exception) {
        throw exception

    }
    @ExceptionHandler(IllegalArgumentException::class)
    fun handle(exception: IllegalArgumentException) {

    }

    @Throws(Exception::class)
    @EventHandler
    fun on(event: ProductCreatedEvent) {
        val record = ProductEntity(event.productId, event.title, event.price, event.quantity)
        try {
            repository.save(record)
        } catch (ex: IllegalArgumentException){
            ex.printStackTrace()
        }

        //throw Exception("Forccing exception in the event handler")
   }



}
