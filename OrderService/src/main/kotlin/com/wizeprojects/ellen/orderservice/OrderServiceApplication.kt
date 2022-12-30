package com.wizeprojects.ellen.orderservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Import

@SpringBootApplication
@EnableDiscoveryClient
@Import(value=[com.wizeprojects.ellen.orderservice.config.AxonConfig::class]) //MUY IMPORTANTE AGREGAR PARA ENLAZAR CON AXON FRAMEWORK
class OrderServiceApplication

fun main(args: Array<String>) {
	runApplication<OrderServiceApplication>(*args)
}
