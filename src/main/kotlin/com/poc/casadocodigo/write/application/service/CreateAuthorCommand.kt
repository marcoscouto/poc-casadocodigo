package com.poc.casadocodigo.write.application.service

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Introspected
data class CreateAuthorCommand(
        @field:NotBlank(message = "Name must not be blank.")
        val name: String,
        @field:NotBlank(message = "Email must not be blank.")
        @field:Email(message = "Please input a valid email.")
        val email: String,
        @field:NotBlank(message = "Description must not be blank.")
        val description: String
)
