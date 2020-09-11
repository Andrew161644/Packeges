package docker.example.Reactive2.Docker.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

@Document(collation = "messages")
open class Mes(var info:String):Serializable{
    @Id
    var id: String?=null
}