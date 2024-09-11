package com.fiap.pombo.dto;

import com.fiap.pombo.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(
        Long id,
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "E-mail em formato inválido")
        String email,

        boolean tema,

        String cor,

        @NotBlank(message = "A senha é obrigatório")
        @Size(min = 6, max= 20, message = "A senha deve conter de 6 a 20 caracteres")
        String senha,

        UsuarioRole role
) {
}