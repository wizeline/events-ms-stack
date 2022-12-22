package com.wizeprojects.ellen.productservice.command

import com.wizeprojects.ellen.productservice.core.data.ProductLookupRepository
import com.wizeprojects.ellen.productservice.core.data.entity.ProductLookupEntity
import com.wizeprojects.ellen.productservice.core.events.ProductCreatedEvent
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component

@Component
@ProcessingGroup("product-group")
class ProductLookupEventsHandler(private val productLookupRepository: ProductLookupRepository) {


    @EventHandler
    fun on(event: ProductCreatedEvent){
        //checking if the event already exists is done by the command dispatch interceptor (CreateProductCommandInterceptor)
        productLookupRepository.save(ProductLookupEntity(event.productId,event.title))

    }
}