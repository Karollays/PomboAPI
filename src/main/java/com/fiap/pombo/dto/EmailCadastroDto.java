package com.fiap.pombo.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.sql.Date;

public record EmailCadastroDto(
        Long idEmail,
        @NotBlank(message = "Email é obrigatório")
        String deEmail,
        @NotBlank(message = "Email é obrigatório")
        String paraEmail,
        @NotBlank(message = "O Assunto é obrigatório")
        String assunto,
        @NotBlank(message = "O colorspo é obrigatório")
        String corpo,
        @NotNull(message = "A data é obrigatório")
        Date dataEmail,
        @NotNull(message = "O spam é obrigatório")
        boolean spam

) {
}
