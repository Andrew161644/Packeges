package docker.example.Reactive2.Docker.models

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepo :ReactiveMongoRepository<Mes,String>{
}