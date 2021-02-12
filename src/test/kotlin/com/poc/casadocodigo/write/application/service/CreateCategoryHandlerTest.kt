package com.poc.casadocodigo.write.application.service

import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.poc.casadocodigo.write.adapter.out.CategoryRepository
import com.poc.casadocodigo.write.application.domain.Category
import io.grpc.StatusRuntimeException
import io.micronaut.validation.validator.Validator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CreateCategoryHandlerTest {

    @Test
    fun `given valid data must create a category`() {

        // given
        val name = "Category 1"
        val command = CreateCategoryCommand(name)
        val repository = mock<CategoryRepository>()
        val handler = CreateCategoryHandler(repository, Validator.getInstance())

        // when
        handler.handle(command)

        // then
        argumentCaptor<Category>().apply {
            verify(repository).save(capture())
            assertEquals(name, firstValue.name)
        }
    }

    @Test
    fun `given invalid data must throw an exception`() {

        // given
        val name = ""
        val command = CreateCategoryCommand(name)
        val repository = mock<CategoryRepository>()
        val handler = CreateCategoryHandler(repository, Validator.getInstance())

        // when/then
        assertThrows(StatusRuntimeException::class.java) { handler.handle(command) }
    }


}