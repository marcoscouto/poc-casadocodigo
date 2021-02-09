package com.poc.write.application.service

import com.poc.write.adapter.out.AuthorRepository
import com.poc.write.application.domain.Author

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
