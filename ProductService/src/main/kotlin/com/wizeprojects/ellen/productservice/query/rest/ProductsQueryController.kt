package com.wizeprojects.ellen.productservice.query.rest

import com.wizeprojects.ellen.productservice.query.FindProductsQuery
import org.axonframework.messaging.responsetypes.ResponseTypes
import org.axonframework.queryhandling.QueryGateway
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class ProductsQueryController(private val queryGateway: QueryGateway) {

    @GetMapping
    fun getProducts(): List<ProductRestModel> {
        return queryGateway.query(FindProductsQuery(),
            ResponseTypes.multipleInstancesOf(ProductRestModel::class.java)
        ).join()
    }
}