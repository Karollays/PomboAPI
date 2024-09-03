package com.fiap.pombo.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Date;

public record EmailCadastroDto(
        Long id,
        @NotBlank(message = "Email é obrigatório")
        String deEmail,
        @NotBlank(message = "Email é obrigatório")
        String paraEmail,
        @NotBlank(message = "O Assunto é obrigatório")
        String assunto,
        @NotNull(message = "A data é obrigatório")
        Date dataEmail,
        @NotNull(message = "O spam é obrigatório")
        Boolean spam

) {
}
