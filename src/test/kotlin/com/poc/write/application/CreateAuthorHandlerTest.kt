package com.poc.write.application

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.poc.write.application.domain.Author
import com.poc.write.application.domain.AuthorRepository
import com.poc.write.application.service.CreateAuthorCommand
import com.poc.write.application.service.CreateAuthorHandler
import org.junit.jupiter.api.Test

class CreateAuthorHandlerTest {

    @Test
    fun `given valid data must create author`() {

        // given
        val name = "Author 1"
        val email = "author@email.com"
        val description = "description"

        val command = CreateAuthorCommand(name, email, description)
        val repository = mock<AuthorRepository>()

        // when
        val handler = CreateAuthorHandler(repository)
        handler.handle(command)

        // then
        verify(repository).create(any<Author>())
    }

}