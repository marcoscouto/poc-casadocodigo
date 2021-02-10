package com.poc.casadocodigo.write.application.service

import com.poc.casadocodigo.write.adapter.out.AuthorRepository
import com.poc.casadocodigo.write.application.domain.Author
import javax.inject.Singleton

@Singleton
class CreateAuthorHandler(private val repository: AuthorRepository) {

    fun handle(command: CreateAuthorCommand) {
        repository.save(
            Author(
                name = command.name,
                email = command.email,
                description = command.description
            )
        )
    }
}
