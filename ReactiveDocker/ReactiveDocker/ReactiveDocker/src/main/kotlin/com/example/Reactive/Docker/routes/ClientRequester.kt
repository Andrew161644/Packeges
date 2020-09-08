package com.example.Reactive.Docker.routes

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.StreamingHttpOutputMessage
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Service
class ClientRequester(
        @Value("\${sa.logic.api.url}")
        private val saLogicApiUrl: String
) {

    fun request():Mono<String>{
        if (saLogicApiUrl!=null) {
            val client = WebClient.create(saLogicApiUrl)
            return client.get().retrieve().bodyToMono(String::class.java)
        }
        return Mono.empty()
    }
}

