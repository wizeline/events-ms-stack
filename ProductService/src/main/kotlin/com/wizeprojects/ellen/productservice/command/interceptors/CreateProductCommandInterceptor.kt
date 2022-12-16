package com.wizeprojects.ellen.productservice.command.interceptors

import com.wizeprojects.ellen.productservice.command.CreateProductCommand
import org.axonframework.commandhandling.CommandMessage
import org.axonframework.messaging.MessageDispatchInterceptor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.function.BiFunction

@Component
class CreateProductCommandInterceptor : MessageDispatchInterceptor<CommandMessage<*>> {

    private val logger: Logger = LoggerFactory.getLogger(CreateProductCommandInterceptor::class.java.simpleName)

    override fun handle(p0: MutableList<out CommandMessage<*>>): BiFunction<Int, CommandMessage<*>, CommandMessage<*>> {
        return BiFunction<Int, CommandMessage<*>, CommandMessage<*>> {
                index: Int?, command: CommandMessage<*> ->
            logger.info("intercepted command: ${command.payloadType}")
            if (CreateProductCommand::class.simpleName == (command.payloadType.simpleName)){
                val interceptCommand = command.payload as CreateProductCommand

                if(interceptCommand.price <= 0) {
                    throw IllegalArgumentException("Price must be greater than zero - interceptor")
                }

                if(interceptCommand.title.isNullOrEmpty()) {
                    throw IllegalArgumentException("Title cannot be empty - interceptor")
                }
            }
            command
        }
    }
}