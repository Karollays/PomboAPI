package com.fiap.pombo.dto;

import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.model.UsuarioRole;

public record UsuarioExibicaoDto(
        Long id,
        String nome,
        String email,
        UsuarioRole role
) {
    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getRole());
    }
}