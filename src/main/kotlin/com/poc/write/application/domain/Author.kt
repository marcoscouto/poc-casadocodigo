package com.poc.write.application.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Author(
        @Id
        @GeneratedValue
        var id: Long? = null,
        var name: String,
        var email: String,
        var description: String
)
