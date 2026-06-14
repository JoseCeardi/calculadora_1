package com.example.calculadora.controllers;

import com.example.calculadora.entities.HistorialEntity;
import com.example.calculadora.repositories.HistorialRepository;
import com.example.calculadora.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;
}
