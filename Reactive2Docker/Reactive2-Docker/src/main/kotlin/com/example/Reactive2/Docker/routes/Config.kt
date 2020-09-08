package com.example.Reactive2.Docker.routes

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
class Config{
    init{
        println("Creation")
    }
    @Bean
    fun gr()= router {
        accept(MediaType.ALL).nest{
            GET(""){serverRequest ->ServerResponse.ok().body(Mono.just("Hello second reactive"),String::class.java)  }
            GET("/get"){serverRequest ->ServerResponse.ok().body(Mono.just("Hello from second reactive"),String::class.java)  }
        }
    }


}
