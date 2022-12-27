package com.wizeprojects.ellen.orderservice.saga

import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.spring.stereotype.Saga
import org.springframework.beans.factory.annotation.Autowired


@Saga
class OrderSaga {

    @Autowired
    @Transient
    private val commandGateway: CommandGateway? = null
}