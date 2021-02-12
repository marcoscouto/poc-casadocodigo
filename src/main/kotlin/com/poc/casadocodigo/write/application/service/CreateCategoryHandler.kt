package com.poc.casadocodigo.write.application.service

import com.poc.casadocodigo.write.adapter.out.CategoryRepository
import io.grpc.Status
import io.micronaut.validation.validator.Validator
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class CreateCategoryHandler(private val repository: CategoryRepository, private val validator: Validator) {

    val log = LoggerFactory.getLogger(CreateCategoryHandler::class.java)

    fun handle(command: CreateCategoryCommand) {
        val validation = validator.validate(command)
        if(validation.isNotEmpty()){
            val errors = validation.map { it.message }.toString()
            log.error("[CATEGORY] Validation errors: $errors")
            throw Status
                .FAILED_PRECONDITION
                .withDescription(errors)
                .asRuntimeException()
        }
        repository.save(command.toEntity())
    }

}
