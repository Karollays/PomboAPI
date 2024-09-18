package com.fiap.pombo.repository;

import com.fiap.pombo.model.Email;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    // Retorna todos os emails
    List<Email> findAll();

    // Filtra por remetente sem paginação
    List<Email> findByDeEmail(String from);
}