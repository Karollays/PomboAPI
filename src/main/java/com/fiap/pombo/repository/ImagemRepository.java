package com.fiap.pombo.repository;

import com.fiap.pombo.model.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {
    // Métodos básicos já são fornecidos pelo JpaRepository
}
