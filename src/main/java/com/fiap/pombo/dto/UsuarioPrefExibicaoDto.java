package com.fiap.pombo.dto;

import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.model.UsuarioRole;

public record UsuarioPrefExibicaoDto(
        Long id,
        Boolean tema,
        String cor

) {
    public UsuarioPrefExibicaoDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.isTema(),
                usuario.getCor());
    }
}
