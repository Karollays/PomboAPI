package com.fiap.pombo.dto;

import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.model.UsuarioRole;

public record UsuarioPrefExibicaoDto(

        Boolean theme,
        String colors

) {
    public UsuarioPrefExibicaoDto(Usuario usuario) {
        this(
                usuario.isTheme(),
                usuario.getColors());
    }
}
