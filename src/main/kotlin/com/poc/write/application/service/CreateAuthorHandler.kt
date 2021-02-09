package com.poc.write.application.service

import com.poc.write.application.domain.Author
import com.poc.write.application.domain.AuthorRepository

class CreateAuthorHandler(private val repository: AuthorRepository) {

    fun handle(command: CreateAuthorCommand) {
        repository.create(Author(command.name, command.email, command.description))
    }

}
