package com.example.calculadora.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="historial")
public class HistorialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    private Integer posicion;
    private String descripcion;
    private String ecuacion;
    private LocalDateTime fecha;
}


