package com.fiap.pombo.repository;

import com.fiap.pombo.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    // JpaRepository já fornece os métodos básicos como save, findAll, findById, existsById e deleteById.
}
