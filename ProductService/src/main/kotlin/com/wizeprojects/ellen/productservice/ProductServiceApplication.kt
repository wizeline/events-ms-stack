package com.wizeprojects.ellen.productservice

import com.wizeprojects.ellen.productservice.core.errorhandling.ProductsServiceEventsErrorHandler
import org.axonframework.config.EventProcessingConfigurer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
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