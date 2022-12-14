package com.wizeprojects.ellen.productservice.query

import com.wizeprojects.ellen.productservice.core.data.entity.ProductEntity
import com.wizeprojects.ellen.productservice.core.data.ProductsRepository
import com.wizeprojects.ellen.productservice.core.events.ProductCreatedEvent
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component


@Component
class ProductEventsHandler (private val repository: ProductsRepository) {

    @EventHandler
    fun handle(event: ProductCreatedEvent) {
//    fun on(event: ProductCreatedEvent, @Autowired @Qualifier("ProductsRepository") productsRepository: ProductsRepository, @SequenceNumber aggregateVersion: Long) {
        val record = ProductEntity(event.productId, event.title, event.price, event.quantity)
        repository.save(record)


    }



}
