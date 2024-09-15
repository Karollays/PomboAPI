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

        @NotNull
        String contas,

        boolean tema,

        @NotNull
        String cor,

        @NotBlank(message = "A senha é obrigatório")
        @Size(min = 6, max= 20, message = "A senha deve conter de 6 a 20 caracteres")
        String senha
) {
        // Construtor personalizado para garantir que 'contas' e 'cor' não sejam nulos
        public UsuarioCadastroDto {
                if (contas == null) {
                        contas = ""; // Define valor padrão como string vazia
                }
                if (cor == null) {
                        cor = ""; // Define valor padrão como string vazia
                }
        }
}