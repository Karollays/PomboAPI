package com.fiap.pombo.dto;

import com.fiap.pombo.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(
        Long id_usuario,
        @NotBlank(message = "username é obrigatório")
        String username,

        String contas,

        boolean theme,

        String colors,

        @NotBlank(message = "A password é obrigatório")
        @Size(min = 6, max= 20, message = "A password deve conter de 6 a 20 caracteres")
        String password
) {
        // Construtor personalizado para garantir que 'contas' e 'colors' não sejam nulos
        public UsuarioCadastroDto {
                if (contas == null) {
                        contas = ""; // Define valor padrão como string vazia
                }
                if (colors == null) {
                        colors = ""; // Define valor padrão como string vazia
                }
        }
}