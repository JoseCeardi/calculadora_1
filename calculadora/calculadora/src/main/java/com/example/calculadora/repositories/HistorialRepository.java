package com.example.calculadora.repositories;

import com.example.calculadora.entities.HistorialEntity;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<HistorialEntity, Long> {
    HistorialEntity fidByPosition(Integer position);
}
