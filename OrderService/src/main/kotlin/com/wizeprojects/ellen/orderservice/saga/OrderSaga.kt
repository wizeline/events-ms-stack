package com.wizeprojects.ellen.orderservice.saga

import com.wizeprojects.ellen.orderservice.core.events.OrderCreatedEvent
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.modelling.saga.SagaEventHandler
import org.axonframework.modelling.saga.StartSaga
import org.axonframework.spring.stereotype.Saga
import org.springframework.beans.factory.annotation.Autowired


@Saga
class OrderSaga {

    @Autowired
    @Transient
    private val commandGateway: CommandGateway? = null

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    fun handle(orderCreatedEvent: OrderCreatedEvent){

    }
}