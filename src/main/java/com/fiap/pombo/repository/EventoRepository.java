package com.fiap.pombo.repository;

import com.fiap.pombo.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Métodos básicos já são fornecidos pelo JpaRepository
}
