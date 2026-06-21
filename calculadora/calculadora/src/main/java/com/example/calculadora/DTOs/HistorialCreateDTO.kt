package com.example.calculadora.DTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistorialCreateDTO {
    private String descripcion;
    private String ecuacion;
    private String resultado;
    private Integer posicion;
}
