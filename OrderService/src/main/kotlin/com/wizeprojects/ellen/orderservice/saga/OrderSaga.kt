package com.wizeprojects.ellen.orderservice.saga


import com.wizeprojects.ellen.core.commands.ReserveProductCommand
import com.wizeprojects.ellen.core.events.ProductReservedEvent
import com.wizeprojects.ellen.orderservice.core.events.OrderCreatedEvent
import org.axonframework.commandhandling.CommandCallback
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.modelling.saga.SagaEventHandler
import org.axonframework.modelling.saga.StartSaga
import org.axonframework.spring.stereotype.Saga
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired


@Saga
class OrderSaga {
    private companion object {
        val logger = LoggerFactory.getLogger(OrderSaga::class.java)
    }

    @Autowired
    @Transient
    private val commandGateway: CommandGateway? = null

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    fun handle(orderCreatedEvent: OrderCreatedEvent){
        val reserveProductCommand = ReserveProductCommand(
            orderCreatedEvent.productId,
            orderCreatedEvent.quantity,
            orderCreatedEvent.orderId,
            orderCreatedEvent.userId
        )
        logger.info(
            "OrderCreatedEvent handled for orderId [{} and productId [{}]",
            reserveProductCommand.orderId,
            reserveProductCommand.productId
        )
        commandGateway!!.send(reserveProductCommand,
            CommandCallback { commandMessage, commandResultMessage ->
                if (commandResultMessage.isExceptional) {
                    // Start a compensating transaction
                    logger.warn(
                        "Failed handling the reserveProductCommand, with output [{} and exception [{}]",
                        commandResultMessage.exceptionResult().message, commandResultMessage.exceptionResult()
                    )
                    /*
                    val rejectOrderCommand = RejectOrderCommand(
                        orderCreatedEvent.getOrderId(),
                        commandResultMessage.exceptionResult().message
                    )
                    commandGateway.send(rejectOrderCommand)

                     */
                }
            })

    }
    @SagaEventHandler(associationProperty = "orderId")
    fun handle(productReservedEvent: ProductReservedEvent) {
        //Process user payment
        logger.info(
            "ProductReservedEvent is called for orderId [{} and productId [{}]",
            productReservedEvent.orderId,
            productReservedEvent.productId
        )
    }

}