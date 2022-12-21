package com.wizeprojects.ellen.productservice.query.rest

import com.wizeprojects.ellen.productservice.query.FindProductsQuery
import org.axonframework.messaging.responsetypes.ResponseTypes
import org.axonframework.queryhandling.QueryGateway
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController

class ProductsQueryController(private val queryGateway: QueryGateway, private val env: Environment) {
    @RequestMapping("/products")
    @GetMapping
    fun getProducts(): List<ProductRestModel> {
        return queryGateway.query(FindProductsQuery(),
            ResponseTypes.multipleInstancesOf(ProductRestModel::class.java)
        ).join()
    }
    @GetMapping
    @RequestMapping("/port")
    fun getPort(): String {
        return "ON PORT ${env.getProperty("local.server.port")}"
    }
}