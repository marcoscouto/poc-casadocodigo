package com.poc.casadocodigo.write.application.service

import com.poc.casadocodigo.common.SelfValidate
import com.poc.casadocodigo.write.application.domain.Category
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
class CreateCategoryCommand(
    @field:NotBlank(message = "Name is required")
    val name: String
) : SelfValidate {

    init {
        selfValidate()
    }

    fun toEntity() = Category(name = name)
}
