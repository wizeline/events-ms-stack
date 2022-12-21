package com.wizeprojects.ellen.productservice.command.interceptors

import org.axonframework.commandhandling.CommandMessage
import org.axonframework.messaging.MessageDispatchInterceptor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.function.BiFunction


class CreateProductCommandInterceptor : MessageDispatchInterceptor<CommandMessage<*>?> {
    override fun handle(messages: List<CommandMessage<*>?>): BiFunction<Int, CommandMessage<*>?, CommandMessage<*>?> {
        return BiFunction { _: Int?, command: CommandMessage<*>? ->
            LOGGER.warn("Intercepting a command {}.", command)
            command
        }
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(CreateProductCommandInterceptor::class.java)
    }
}