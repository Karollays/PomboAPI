package com.fiap.pombo.controller;

import com.fiap.pombo.dto.EmailCadastroDto;
import com.fiap.pombo.dto.EmailExibicaoDto;
import com.fiap.pombo.dto.EventoCadastroDto;
import com.fiap.pombo.dto.EventoExibicaoDto;
import com.fiap.pombo.exception.EmailNaoExisteException;
import com.fiap.pombo.exception.EventoNaoExisteException;
import com.fiap.pombo.model.Evento;
import com.fiap.pombo.service.EventoService;
import com.fiap.pombo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventoController {

    @Autowired
    private EventoService eventoService;
    private UsuarioService usuarioService;

    // Criar um novo evento
    @PostMapping("/eventos")
    @ResponseStatus(HttpStatus.CREATED)
    public EventoExibicaoDto salvar(@RequestBody @Valid EventoCadastroDto eventoCadastroDto) {
        return eventoService.salvar(eventoCadastroDto);
    }

    // Lista de eventos
    @GetMapping("/eventos")
    @ResponseStatus(HttpStatus.OK)
    public Page<EventoExibicaoDto> listarEvento(Pageable paginacao) {
        return eventoService.listarEvento(paginacao);
    }


    // Obter um evento específico pelo ID
    @GetMapping("/eventos/{idEvento}")
    public ResponseEntity<EventoExibicaoDto> buscar(@PathVariable Long idEvento) {
        try {
            EventoExibicaoDto evento = eventoService.buscar(idEvento);
            return new ResponseEntity<>(evento, HttpStatus.OK);
        } catch (EventoNaoExisteException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Atualizar um evento existente
    @PutMapping("/eventos")
    public EventoExibicaoDto atualizar(@RequestBody @Valid EventoCadastroDto eventoCadastroDto) {
        return eventoService.atualizar(eventoCadastroDto);
    }

    // Deletar um evento
    @DeleteMapping("/eventos/{idEvento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long idEvento) {
        eventoService.deletar(idEvento);
    }
}
