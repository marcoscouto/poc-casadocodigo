package com.poc.casadocodigo.write.application.service

import com.poc.casadocodigo.write.adapter.out.CategoryRepository
import javax.inject.Singleton

@Singleton
class CreateCategoryHandler(
    private val repository: CategoryRepository
) {
    fun handle(command: CreateCategoryCommand) {
        repository.save(command.toEntity())
    }
}
