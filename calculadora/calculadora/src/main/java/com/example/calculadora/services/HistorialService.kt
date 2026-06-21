package com.example.calculadora.services;

import com.example.calculadora.entities.HistorialEntity;
import com.example.calculadora.repositories.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HistorialService {
    @Autowired
    private HistorialRepository historialRepository;

    public Optional<HistorialEntity> getHistorial(Long id) {
        return historialRepository.findById(id);
    }

    public HistorialEntity createHistorial(@RequestBody HistorialEntity historialEntity) {
        HistorialEntity historial = new HistorialEntity();
        historial.setId(historial.getId());
        historial.setDescripcion(historialEntity.getDescripcion());
        historial.setEcuacion(historialEntity.getEcuacion());
        historial.setPosicion(historialEntity.getPosicion());
        historial.setResultado(historialEntity.getResultado());
        historial.setFecha(LocalDateTime.now());
        historialRepository.save(historial);
        return historial;
    }

    public List<HistorialEntity> getAllHistorials() {
        return historialRepository.findAll();
    }

}
