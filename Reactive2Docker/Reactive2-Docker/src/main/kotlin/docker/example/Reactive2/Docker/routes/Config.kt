package docker.example.Reactive2.Docker.routes

import docker.example.Reactive2.Docker.Handler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
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
    fun gr(handler: Handler)= router {
        accept(MediaType.ALL).nest{
            GET(""){serverRequest ->ServerResponse.ok().body(Mono.just("Hello second reactive"),String::class.java)  }
            POST("/add"){serverRequest ->handler.handleAdd(serverRequest) }
            GET("/get"){serverRequest ->ServerResponse.ok().body(Mono.just("Hello from second reactive"),String::class.java)  }
        }
    }


}
