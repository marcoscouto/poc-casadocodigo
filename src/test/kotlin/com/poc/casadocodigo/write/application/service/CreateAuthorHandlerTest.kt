package com.poc.casadocodigo.write.application.service

import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.poc.casadocodigo.write.adapter.out.AuthorRepository
import com.poc.casadocodigo.write.application.domain.Author
import org.junit.jupiter.api.Assertions
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
        argumentCaptor<Author>().apply {
            verify(repository).save(capture())
            Assertions.assertEquals(name, firstValue.name)
            Assertions.assertEquals(email, firstValue.email)
            Assertions.assertEquals(description, firstValue.description)
        }
    }
}