package com.wizeprojects.ellen.productservice.core.data.entity

import javax.persistence.*


@Entity
@Table(name="products")
data class ProductEntity(
    @Id
    @Column(unique = true)
    val productId: String,

    @Column(unique = true)
    val title: String,
    val price: Long,
    val quantity: Int
)
