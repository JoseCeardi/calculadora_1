package com.example.calculadora.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "historial")
open class HistorialEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(nullable = false, unique = true)
        open var id: Long? = null,

        open var descripcion: String? = null,
        open var ecuacion: String? = null,
        open var resultado: String? = null,
        open var fecha: LocalDateTime? = null
        )