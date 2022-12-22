package com.wizeprojects.ellen.productservice.core.data.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="productlookup")
data class ProductLookupEntity (

    @Id
    @Column(unique = true)
    val productId: String,

    @Column(unique = true)
    val title: String
)