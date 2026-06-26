package com.example.calculadora.repositories

import com.example.calculadora.entities.HistorialEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface HistorialRepository : JpaRepository<HistorialEntity, Long> {
    fun findByFechaBefore(fecha: LocalDateTime): List<HistorialEntity>
}

