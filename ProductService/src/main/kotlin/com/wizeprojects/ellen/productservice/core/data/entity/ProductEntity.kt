package com.wizeprojects.ellen.productservice.core.data.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name="products")
data class ProductEntity(
    @Id
    @Column(unique = true)
    val productId: String,

    @Column(unique = true)
    val title: String,
    val price: Long,
    var quantity: Int
)
