package com.wizeprojects.ellen.productservice.command.rest

import com.wizeprojects.ellen.productservice.command.CreateProductCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/products") //http://localhost:8080/products
class ProductsCommandController(val env: Environment, val commandGateway : CommandGateway ) {

    @PostMapping
    fun createProduct(@Valid @RequestBody createProductRestModel: CreateProductRestModel): String {
        val createProductCommand = CreateProductCommand(UUID.randomUUID().toString(),createProductRestModel.title, createProductRestModel.price, createProductRestModel.quantity)

        return  commandGateway.sendAndWait(createProductCommand);
        /*
        try {
            commandGateway.sendAndWait(createProductCommand);
        } catch (e: Exception) {
            return e.localizedMessage;
        }

        return "HTTP POST HANDLED ${createProductRestModel.title}"
        */
    }
/*
    @GetMapping
    fun getProduct(): String {
        return "HTTP GET HANDLED ${env.getProperty("local.server.port")}"
    }


    @PutMapping
    fun updateProduct(): String {
        return "HTTP PUT HANDLED"
    }

    @DeleteMapping
    fun deleteProduct(): String {
        return "HTTP DELETE HANDLED"
    }
*/
}