package com.wizeprojects.ellen.productservice.configuration

import com.wizeprojects.ellen.productservice.command.interceptors.CreateProductCommandInterceptor
import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.SimpleCommandBus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

//TODO although on build it seems to be registering the commandInterceptor it does NOT really seems to work
@Configuration
class CommandBusConfiguration {
    fun registerInterceptors(@Autowired commandBus: CommandBus?) {
        if (commandBus is SimpleCommandBus) {
            commandBus.registerDispatchInterceptor (CreateProductCommandInterceptor())
        }
    }
}
    