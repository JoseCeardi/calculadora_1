package com.example.calculadora.services;

import com.example.calculadora.entities.HistorialEntity;
import com.example.calculadora.repositories.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HistorialService {
    @Autowired
    private HistorialRepository historialRepository;

    public Optional<HistorialEntity> getHistorial(Long id) {
        return historialRepository.findById(id);
    }



}
