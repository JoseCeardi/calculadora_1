package com.example.calculadora.repositories;

import com.example.calculadora.entities.HistorialEntity;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistorialRepository extends JpaRepository<HistorialEntity, Long> {
    @Query(value="SELECT h.id FROM historial h WHERE h.id = :id", nativeQuery=true)
    Optional<HistorialEntity> getHistorial(@Param("id") Long id);
}
