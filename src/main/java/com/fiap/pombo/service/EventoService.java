package com.fiap.pombo.service;

import com.fiap.pombo.model.Evento;
import com.fiap.pombo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // Salva um novo evento
    public Evento saveEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    // Retorna todos os eventos
    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    // Retorna um evento pelo ID
    public Evento getEventoById(Long id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        return evento.orElse(null);
    }

    // Atualiza um evento existente
    public Evento updateEvento(Long id, Evento eventoDetails) {
        Optional<Evento> optionalEvento = eventoRepository.findById(id);
        if (optionalEvento.isPresent()) {
            Evento existingEvento = optionalEvento.get();
            existingEvento.setTitulo(eventoDetails.getTitulo());
            existingEvento.setDataInicial(eventoDetails.getDataInicial());
            existingEvento.setHoraInicial(eventoDetails.getHoraInicial());
            existingEvento.setDataFinal(eventoDetails.getDataFinal());
            existingEvento.setHoraFinal(eventoDetails.getHoraFinal());
//            existingEvento.setDescricao(eventoDetails.getDescricao());
            existingEvento.setLocalizacao(eventoDetails.getLocalizacao());
            return eventoRepository.save(existingEvento);
        } else {
            return null;
        }
    }

    // Deleta um evento pelo ID
    public boolean deleteEvento(Long id) {
        if (eventoRepository.existsById(id)) {
            eventoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
