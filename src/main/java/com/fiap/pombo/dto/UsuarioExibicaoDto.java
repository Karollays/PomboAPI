package com.fiap.pombo.dto;

import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.model.UsuarioRole;

public record UsuarioExibicaoDto(
        Long id,
        String nome,
        String email,
        String contas,
        Boolean tema,
        String cor,
        UsuarioRole role
) {
    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getContas(),
                usuario.isTema(),
                usuario.getCor(),
                usuario.getRole());
    }
}