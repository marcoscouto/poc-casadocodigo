package com.poc.casadocodigo.write.application.service

data class CreateAuthorCommand(val name: String,
                               val email: String,
                               val description: String)
