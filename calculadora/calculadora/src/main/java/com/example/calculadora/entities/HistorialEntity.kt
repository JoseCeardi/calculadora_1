package com.example.calculadora.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="historial")
public class HistorialEntity {
    @Id
    @Column(nullable=false, unique=true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    @Column(nullable=false, unique=true)
    private Integer posicion;

    private String descripcion;
    private String ecuacion;
    private String resultado;
    private LocalDateTime fecha;
}


