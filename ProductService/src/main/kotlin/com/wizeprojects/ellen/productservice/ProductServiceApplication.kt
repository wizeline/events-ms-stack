package com.wizeprojects.ellen.productservice

import com.wizeprojects.ellen.productservice.core.errorhandling.ProductsServiceEventsErrorHandler
import org.axonframework.config.EventProcessingConfigurer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Import

@SpringBootApplication
@EnableDiscoveryClient
@Import(value=[com.wizeprojects.ellen.productservice.config.AxonConfig::class]) //MUY IMPORTANTE AGREGAR PARA ENLAZAR CON AXON FRAMEWORK
class ProductServiceApplication {

	@Autowired
	fun configure(config: EventProcessingConfigurer) {
//		config.registerListenerInvocationErrorHandler("product-group") ({ conf -> PropagatingErrorHandler::instance()}
		config.registerListenerInvocationErrorHandler("product-group"){ _ -> ProductsServiceEventsErrorHandler() }

	}
}

fun main(args: Array<String>) {
	runApplication<ProductServiceApplication>(*args)
}