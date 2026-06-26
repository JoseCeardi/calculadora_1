package com.example.calculadora

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class CalculadoraApplication

fun main(args: Array<String>) {
    runApplication<CalculadoraApplication>(*args)
}