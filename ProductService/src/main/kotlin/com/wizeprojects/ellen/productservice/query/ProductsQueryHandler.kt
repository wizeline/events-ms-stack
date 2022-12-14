package com.wizeprojects.ellen.productservice.query

import com.wizeprojects.ellen.productservice.core.data.ProductsRepository
import com.wizeprojects.ellen.productservice.core.data.entity.ProductEntity
import com.wizeprojects.ellen.productservice.query.rest.ProductRestModel
import org.axonframework.queryhandling.QueryHandler
import org.springframework.stereotype.Component

@Component
class ProductsQueryHandler(private val productsRepository: ProductsRepository) {

    @QueryHandler
    fun findProducts(findProductsQuery: FindProductsQuery): List<ProductRestModel> {
        val productsRestModel = mutableListOf<ProductRestModel>()
        val storedProducts: List<ProductEntity> = productsRepository.findAll()
        storedProducts.forEach{
            productsRestModel.add(ProductRestModel(it.productId,it.title,it.price,it.quantity))
        }
        return productsRestModel
    }
}