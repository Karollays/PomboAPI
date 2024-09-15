package com.fiap.pombo.dto;

import com.fiap.pombo.model.Email;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.sql.Timestamp;

public record EventoCadastroDto(

        Long idEvento,
        Long idUsuario,
        @NotBlank(message = "Titulo é obrigatório")
        String titulo,
        @NotNull(message = "Data inicial é obrigatório")
        Date dataInicial,
        @NotNull(message = "Hora inicial é obrigatório")
        Timestamp horaInicial,
        @NotNull(message = "Data final é obrigatório")
        Date dataFinal,
        @NotNull(message = "Hora final é obrigatório")
        Timestamp horaFinal,
        @NotBlank(message = "Localização é obrigatório")
        String localizacao,
        @NotBlank(message = "Descrição é obrigatório")
        String descricao
) {
}
