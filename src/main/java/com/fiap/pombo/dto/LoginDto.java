package com.fiap.pombo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(
        @NotBlank(message = "O username é obrigatório!")
        String username,

        @NotBlank(message = "A password é obrigatória!")
        @Size(min = 6, max = 20, message = "A password deve conter de 6 a 20 caracteres")
        String password
) {
}

