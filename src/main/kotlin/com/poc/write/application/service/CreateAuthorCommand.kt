package com.poc.write.application.service

data class CreateAuthorCommand(val name: String,
                               val email: String,
                               val description: String)
