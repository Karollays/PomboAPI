package com.fiap.pombo.dto;

import com.fiap.pombo.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(
        Long id,

        String nome,

//        @NotBlank(message = "CPF é obrigatório")
////      @Size(min = 11, max = 11, message = "O campo deve conter 11 caracteres")
//        String cpf,

        String email,

        Boolean tema,

        String cor,

        String senha,



//        @NotNull(message = "Id do imóvel é obrigatório")
//        Long imovelId,

        UsuarioRole role
) {
}