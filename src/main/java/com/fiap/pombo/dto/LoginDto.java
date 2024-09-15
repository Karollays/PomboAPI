package com.fiap.pombo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(
        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @NotBlank(message = "A senha é obrigatória!")
        @Size(min = 6, max = 20, message = "A senha deve conter de 6 a 20 caracteres")
        String senha
) {
}

