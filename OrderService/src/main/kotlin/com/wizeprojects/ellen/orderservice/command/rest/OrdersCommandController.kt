package com.wizeprojects.ellen.orderservice.command.rest

import com.wizeprojects.ellen.orderservice.command.CreateOrderCommand
import com.wizeprojects.ellen.orderservice.core.model.OrderStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.axonframework.commandhandling.gateway.CommandGateway
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/orders")
class OrdersCommandController(val commandGateway : CommandGateway) {
    @PostMapping
    fun createOrder(@Valid @RequestBody createOrderRestModel: CreateOrderRestModel): String {
        val createOrderCommand = CreateOrderCommand(
            createOrderRestModel.productId,
            createOrderRestModel.quantity,
            createOrderRestModel.addressId,
            OrderStatus.CREATED
        )

        return  commandGateway.sendAndWait(createOrderCommand);
    }
}