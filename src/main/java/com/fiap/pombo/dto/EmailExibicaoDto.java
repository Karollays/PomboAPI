package com.fiap.pombo.dto;

import com.fiap.pombo.model.Email;
import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.model.UsuarioRole;

import java.util.Date;

public record EmailExibicaoDto(
        Long idEmail,
        String deEmail,
        String paraEmail,
        String assunto,
        Date dataEmail,
        Boolean spam
) {
    public EmailExibicaoDto(Email email) {
        this(
                email.getIdEmail(),
                email.getDeEmail(),
                email.getParaEmail(),
                email.getAssunto(),
                email.getDataEmail(),
                email.isSpam());
    }
}
