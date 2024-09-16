package com.fiap.pombo.dto;

import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.model.UsuarioRole;

public record UsuarioExibicaoDto(
        Long id,
        String username,
        String contas,
        boolean theme,
        String colors
) {
    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getContas(),
                usuario.isTheme(),
                usuario.getColors());
    }
}