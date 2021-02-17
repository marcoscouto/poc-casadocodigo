package com.poc.casadocodigo.write.application.service

import com.poc.casadocodigo.write.adapter.out.AuthorRepository
import com.poc.casadocodigo.write.application.domain.Author
import io.grpc.Status
import javax.inject.Singleton
import io.micronaut.validation.validator.Validator

@Singleton
class CreateAuthorHandler(private val repository: AuthorRepository, private val validator: Validator) {

    fun handle(command: CreateAuthorCommand) {

        val validation = validator.validate(command)
        if (validation.isNotEmpty()){
            val errors = validation.map { it.message }.toString()
            throw Status
                    .FAILED_PRECONDITION
                    .withDescription(errors)
                    .asRuntimeException()
        }

        repository.save(
            Author(
                name = command.name,
                email = command.email,
                description = command.description
            )
        )
    }
}
