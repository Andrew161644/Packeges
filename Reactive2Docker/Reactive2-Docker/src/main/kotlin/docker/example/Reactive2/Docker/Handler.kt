package docker.example.Reactive2.Docker

import docker.example.Reactive2.Docker.models.Mes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Service
class Handler(
        @Autowired var oper:MessageOperator
) {

    fun handleAdd(request:ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(String::class.java).doOnNext { t:String->
            oper.save(t)

        }.then(ServerResponse.ok().body(
                oper.getAll(),Mes::class.java
        ))

    }
    fun handleGet(request:ServerRequest): Mono<ServerResponse>{
        val id=request.queryParam("id").toString()
        val then = oper.getById(id).flatMap { t-> Mono.just(t.info) }
        return ServerResponse.ok().body(then,String::class.java)
    }
}