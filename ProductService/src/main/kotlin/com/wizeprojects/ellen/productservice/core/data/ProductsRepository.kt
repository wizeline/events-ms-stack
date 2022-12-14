package com.wizeprojects.ellen.productservice.core.data

import com.wizeprojects.ellen.productservice.core.data.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductsRepository : JpaRepository<ProductEntity, String> {
    fun findByProductId(id: String): ProductEntity
    fun findByProductIdOrTitle(id: String, title: String): ProductEntity
}