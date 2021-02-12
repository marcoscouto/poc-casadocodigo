package com.poc.casadocodigo.write.adapter.out

import com.poc.casadocodigo.write.application.domain.Category
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface CategoryRepository : CrudRepository<Category, Long>