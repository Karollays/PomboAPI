package com.fiap.pombo.dto;

import com.fiap.pombo.model.Email;
import com.fiap.pombo.model.Evento;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;
import java.sql.Timestamp;

public record EventoExibicaoDto(

        Long idEvento,
        String titulo,
        Date dataInicial,
        Timestamp horaInicial,
        Date dataFinal,
        Timestamp horaFinal,
        String localizacao,
        String descaricao
) {
    public EventoExibicaoDto(Evento evento){
        this(
                evento.getIdEvento(),
                evento.getTitulo(),
                evento.getDataInicial(),
                evento.getHoraInicial(),
                evento.getDataFinal(),
                evento.getHoraFinal(),
                evento.getLocalizacao(),
                evento.getDescricao()
        );
    }
}