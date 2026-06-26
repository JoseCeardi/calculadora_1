package com.example.calculadora.controllers

import com.example.calculadora.entities.HistorialEntity
import com.example.calculadora.services.HistorialService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/historial")
class HistorialController(
        private val historialService: HistorialService
) {

    @GetMapping("/{id}")
    fun getHistorial(@PathVariable id: Long): ResponseEntity<HistorialEntity> {
        val entity = historialService.getHistorial(id)
        return if (entity != null) {
            ResponseEntity.ok(entity)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun getAllHistorials(): ResponseEntity<List<HistorialEntity>> {
        val historiales = historialService.getAllHistorials()
        return ResponseEntity.ok(historiales)
    }

    @PostMapping
    fun createHistorial(@RequestBody historialEntity: HistorialEntity): ResponseEntity<HistorialEntity> {
        val historial = historialService.createHistorial(historialEntity)
        return ResponseEntity.ok(historial)
    }

    @GetMapping("/fecha/{date}")
    fun getAllHistoriaslOnDate(@PathVariable("date") date: LocalDateTime): ResponseEntity<List<HistorialEntity>> {
        val historiales = historialService.getAllHistorialsOnDate(date)

        return if (historiales.isEmpty()) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok(historiales)
        }
    }
}