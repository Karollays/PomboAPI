package com.fiap.pombo.repository;

import com.fiap.pombo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT c FROM Usuario c WHERE c.nome = :nome")
    Optional<Usuario> findByNome(@Param("nome") String nome);

    UserDetails findByEmail(String email);
}
