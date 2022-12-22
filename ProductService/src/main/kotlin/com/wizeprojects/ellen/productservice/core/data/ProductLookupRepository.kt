package com.wizeprojects.ellen.productservice.core.data

import com.wizeprojects.ellen.productservice.core.data.entity.ProductLookupEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductLookupRepository : JpaRepository<ProductLookupEntity, String> {
    fun findByProductIdOrTitle(productId: String, title: String): ProductLookupEntity?
}