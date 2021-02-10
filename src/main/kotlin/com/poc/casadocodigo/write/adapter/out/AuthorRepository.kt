package com.poc.casadocodigo.write.adapter.out

import com.poc.casadocodigo.write.application.domain.Author
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface AuthorRepository : CrudRepository<Author, Long> {

}