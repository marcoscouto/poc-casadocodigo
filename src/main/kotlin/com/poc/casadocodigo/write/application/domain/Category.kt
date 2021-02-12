package com.poc.casadocodigo.write.application.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Category(
    @Id
    @GeneratedValue
    var id: Long? = null,
    val name: String
)