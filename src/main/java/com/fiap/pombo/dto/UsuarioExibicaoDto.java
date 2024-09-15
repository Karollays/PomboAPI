package com.fiap.pombo.dto;

import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.model.UsuarioRole;

public record UsuarioExibicaoDto(
        Long id,
        String nome,
        String contas,
        boolean tema,
        String cor
) {
    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getContas(),
                usuario.isTema(),
                usuario.getCor());
    }
}