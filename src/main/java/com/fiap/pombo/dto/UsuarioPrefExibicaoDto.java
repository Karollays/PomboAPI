package com.fiap.pombo.dto;

import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.model.UsuarioRole;

public record UsuarioPrefExibicaoDto(

        Boolean tema,
        String cor

) {
    public UsuarioPrefExibicaoDto(Usuario usuario) {
        this(
                usuario.isTema(),
                usuario.getCor());
    }
}
