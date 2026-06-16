package com.example.calculadora.controllers;

import com.example.calculadora.entities.HistorialEntity;
import com.example.calculadora.repositories.HistorialRepository;
import com.example.calculadora.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping("/id/{id}")
    public ResponseEntity<HistorialEntity> getHistorial(@PathVariable("id") Long id) {
        HistorialEntity historialEntity = historialService.getHistorial(id).orElse(null);
        if (historialEntity.getId().equals(id)) {
            return ResponseEntity.ok(historialEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<HistorialEntity> saveHistorial(@RequestBody HistorialEntity historialEntity) {
        boolean createHistory = historialService.crearHistorial()
    }
}
