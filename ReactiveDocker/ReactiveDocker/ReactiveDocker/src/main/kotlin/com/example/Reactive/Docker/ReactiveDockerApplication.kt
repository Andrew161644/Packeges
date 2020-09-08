package com.example.Reactive.Docker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveDockerApplication

fun main(args: Array<String>) {
	print("version v1")
	runApplication<ReactiveDockerApplication>(*args)
}
