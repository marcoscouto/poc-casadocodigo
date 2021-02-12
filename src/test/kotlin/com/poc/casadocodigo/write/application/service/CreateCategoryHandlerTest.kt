package com.poc.casadocodigo.write.application.service

import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.poc.casadocodigo.write.adapter.out.CategoryRepository
import com.poc.casadocodigo.write.application.domain.Category
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateCategoryHandlerTest {

    @Test
    fun `given valid data must create a category`() {

        // given
        val name = "Category 1"
        val command = CreateCategoryCommand(name)
        val repository = mock<CategoryRepository>()
        val handler = CreateCategoryHandler(repository)

        // when
        handler.handle(command)

        // then
        argumentCaptor<Category>().apply {
            verify(repository).save(capture())
            assertEquals(name, firstValue.name)
        }
    }
}
