package com.example.calculadora.controllers;

import com.example.calculadora.entities.HistorialEntity;
import com.example.calculadora.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping("/{id}")
    public ResponseEntity<HistorialEntity> getHistorial(@PathVariable("id") Long id) {
        HistorialEntity entity = historialService.getHistorial(id).orElse(null);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<HistorialEntity>> getAllHistorials() {
        List<HistorialEntity> historiales = historialService.getAllHistorials();
        if (historiales != null) {
            return ResponseEntity.ok(historiales);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<HistorialEntity> createHistorial(@RequestBody HistorialEntity historialEntity) {
        HistorialEntity historial = historialService.createHistorial(historialEntity);
        if (historial != null) {
            return ResponseEntity.ok(historial);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }



}
