package com.wizeprojects.ellen.productservice.core.errorhandling

import org.axonframework.eventhandling.EventMessage
import org.axonframework.eventhandling.EventMessageHandler
import org.axonframework.eventhandling.ListenerInvocationErrorHandler
import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice
class ProductsServiceEventsErrorHandler: ListenerInvocationErrorHandler {

    override fun onError(p0: java.lang.Exception, p1: EventMessage<*>, p2: EventMessageHandler) {
        throw p0
    }
}