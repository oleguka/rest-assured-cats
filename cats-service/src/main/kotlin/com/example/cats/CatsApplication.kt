package com.example.cats

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CatsApplication

fun main(args: Array<String>) {
    runApplication<CatsApplication>(*args)
}