package com.poc.casadocodigo.write.adapter.`in`

import com.google.protobuf.Empty
import com.poc.casadocodigo.proto.CasadoCodigoServiceGrpcKt.CasadoCodigoServiceCoroutineImplBase
import com.poc.casadocodigo.proto.CreateAuthorRequest
import com.poc.casadocodigo.write.application.service.CreateAuthorCommand
import com.poc.casadocodigo.write.application.service.CreateAuthorHandler
import javax.inject.Singleton

@Singleton
class AuthorEndpoint(
    private val handler: CreateAuthorHandler
) : CasadoCodigoServiceCoroutineImplBase() {

    override suspend fun createAuthor(request: CreateAuthorRequest): Empty {

        val command = CreateAuthorCommand(
            request.name,
            request.email,
            request.description
        )

        handler.handle(command)

        return Empty.newBuilder().build();
    }
}
