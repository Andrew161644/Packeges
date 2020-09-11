package docker.example.Reactive2.Docker

import docker.example.Reactive2.Docker.models.Mes
import docker.example.Reactive2.Docker.models.MessageRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class MessageOperator(
        @Autowired var repo: MessageRepo
){
    fun save(info:String){
        repo.save(Mes(info))
    }
    fun getAll(): Flux<Mes> {
        return repo.findAll()
    }
    fun getById(id:String):Mono<Mes>{
        return repo.findById(id)
    }
}