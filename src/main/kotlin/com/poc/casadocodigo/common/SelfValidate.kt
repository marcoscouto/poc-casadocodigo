package com.poc.casadocodigo.common

import io.micronaut.validation.validator.Validator
import javax.validation.ConstraintViolationException

interface SelfValidate {

    fun selfValidate() {
        val validator = Validator.getInstance()
        val violations = validator.validate(this)
        if (violations.isNotEmpty()) {
            throw ConstraintViolationException(violations)
        }
    }
}
