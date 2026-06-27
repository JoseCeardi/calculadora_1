package com.example.calculadora.services

import com.example.calculadora.entities.HistorialEntity
import com.example.calculadora.repositories.HistorialRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class HistorialService(
        private val historialRepository: HistorialRepository
) {

    fun getHistorial(id: Long): HistorialEntity? =
            historialRepository.findByIdOrNull(id)

    fun getAllHistorials(): List<HistorialEntity> =
            historialRepository.findAll()

    fun createHistorial(historialEntity: HistorialEntity): HistorialEntity {

        val historial = HistorialEntity(
            descripcion = historialEntity.descripcion,
            ecuacion = historialEntity.ecuacion,
            resultado = historialEntity.resultado,
            fecha = LocalDateTime.now()
        )

        return historialRepository.save(historial)
    }

    fun getAllHistorialsOnDate(date: LocalDateTime): List<HistorialEntity> {
        return historialRepository.findByFechaBefore(date)
    }
}