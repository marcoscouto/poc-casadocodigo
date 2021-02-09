package com.poc.write.application.domain

import io.micronaut.data.annotation.Repository

@Repository
interface AuthorRepository {

    fun create(author: Author)

}
