package com.poc.casadocodigo.write.adapter.`in`

import com.google.protobuf.Empty
import com.poc.casadocodigo.proto.CategoryServiceGrpcKt
import com.poc.casadocodigo.proto.CreateCategoryRequest
import com.poc.casadocodigo.write.application.service.CreateCategoryCommand
import com.poc.casadocodigo.write.application.service.CreateCategoryHandler
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class CategoryEndpoint(private val handler: CreateCategoryHandler):
    CategoryServiceGrpcKt.CategoryServiceCoroutineImplBase() {

    val log = LoggerFactory.getLogger(CategoryEndpoint::class.java)

    override suspend fun createCategory(request: CreateCategoryRequest): Empty {
        log.info("[CATEGORY] Create category request")
        val command = CreateCategoryCommand(request.name)
        handler.handle(command)
        return Empty.getDefaultInstance()
    }

}