package com.fiap.pombo.dto;

import com.fiap.pombo.model.Email;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;
import java.sql.Timestamp;

public record EventoCadastroDto(

        Long idEvento,
        Long idUsuario,
        Long Email,
        @NotBlank(message = "Titulo é obrigatório")
        String titulo,
        @NotBlank(message = "Data inicial é obrigatório")
        Date dataInicial,
        @NotBlank(message = "Hora inicial é obrigatório")
        Timestamp horaInicial,
        @NotBlank(message = "Data final é obrigatório")
        Date dataFinal,
        @NotBlank(message = "Hora final é obrigatório")
        Timestamp horaFinal,
        @NotBlank(message = "Localização é obrigatório")
        String localizacao
) {
}
