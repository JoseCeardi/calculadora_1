package com.example.calculadora.dtos

data class HistorialCreateDTO(
        val descripcion: String,
        val ecuacion: String,
        val resultado: String
)