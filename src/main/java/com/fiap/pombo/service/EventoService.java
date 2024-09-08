package com.fiap.pombo.service;

import com.fiap.pombo.dto.EmailCadastroDto;
import com.fiap.pombo.dto.EmailExibicaoDto;
import com.fiap.pombo.dto.EventoCadastroDto;
import com.fiap.pombo.dto.EventoExibicaoDto;
import com.fiap.pombo.exception.EmailNaoExisteException;
import com.fiap.pombo.exception.EventoNaoExisteException;
import com.fiap.pombo.model.Email;
import com.fiap.pombo.model.Evento;
import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.repository.EmailRepository;
import com.fiap.pombo.repository.EventoRepository;
import com.fiap.pombo.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EmailRepository emailRepository;

    // Salva um novo evento no banco de dados

    @Transactional
    public EventoExibicaoDto salvar(EventoCadastroDto eventoCadastroDto) {
        // Verificar se o idUsuario no DTO não é nulo
        if (eventoCadastroDto.idUsuario() == null) {
            throw new IllegalArgumentException("O ID do usuário não pode ser nulo.");
        }

        // Encontrar o usuário pelo ID fornecido no DTO
        Usuario usuario = usuarioRepository.findById(eventoCadastroDto.idUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        // Verificar se o idEmail no DTO não é nulo
        if (eventoCadastroDto.idEmail() == null) {
            throw new IllegalArgumentException("O ID do email não pode ser nulo.");
        }

        // Encontrar o email pelo ID fornecido no DTO
        Email email = emailRepository.findById(eventoCadastroDto.idEmail())
                .orElseThrow(() -> new IllegalArgumentException("Email não encontrado."));

        // Criar a nova instância de evento
        Evento evento = new Evento();
        evento.setTitulo(eventoCadastroDto.titulo());
        evento.setDataInicial(eventoCadastroDto.dataInicial());
        evento.setHoraInicial(eventoCadastroDto.horaInicial());
        evento.setDataFinal(eventoCadastroDto.dataFinal());
        evento.setHoraFinal(eventoCadastroDto.horaFinal());
        evento.setLocalizacao(eventoCadastroDto.localizacao());

        // Associar o usuário e o email ao evento
        evento.setUsuario(usuario);
        evento.setEmail(email);

        // Salvar e retornar o DTO de resposta
        return new EventoExibicaoDto(eventoRepository.save(evento));
    }

//    @Transactional
//    public EventoExibicaoDto salvar(EventoCadastroDto eventoCadastroDto) {
//        // Verificar se o idUsuario no DTO não é nulo
//        if (eventoCadastroDto.idUsuario() == null) {
//            throw new IllegalArgumentException("O ID do usuário não pode ser nulo.");
//        }
//
//        // Encontrar o usuário pelo ID fornecido no DTO
//        Usuario usuario = usuarioRepository.findById(eventoCadastroDto.idUsuario())
//                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
//
//        // Criar a nova instância de evento
//        Evento evento = new Evento();
//        evento.setTitulo(eventoCadastroDto.titulo()); // Adicionado Adriano
//        evento.setDataInicial(eventoCadastroDto.dataInicial());
//        evento.setHoraInicial(eventoCadastroDto.horaInicial());
//        evento.setDataFinal(eventoCadastroDto.dataFinal());
//        evento.setHoraFinal(eventoCadastroDto.horaFinal());
//        evento.setLocalizacao(eventoCadastroDto.localizacao());
//
//        // Associar o usuário ao evento
//        evento.setUsuario(usuario);
//
//        // Salvar e retornar o DTO de resposta
//        return new EventoExibicaoDto(eventoRepository.save(evento));
//    }


    // Retorna todos os eventos cadastrados
    @Transactional(readOnly = true)
    public Page<EventoExibicaoDto> listarEvento(Pageable paginacao) {
        return eventoRepository
                .findAll(paginacao)
                .map(EventoExibicaoDto::new);
    }

    // Retorna um evento pelo ID
    @Transactional(readOnly = true)
    public EventoExibicaoDto buscar(Long idEvento) {
        Optional<Evento> eventoOptional = eventoRepository.findById(idEvento);
        if (eventoOptional.isPresent()) {
            return new EventoExibicaoDto(eventoOptional.get());
        } else {
            throw new EventoNaoExisteException("Evento não encontrado.");
        }
    }
    // Atualiza um evento existente pelo ID
    @Transactional
    public EventoExibicaoDto atualizar(EventoCadastroDto eventoCadastroDto) {
        Evento evento = eventoRepository.findById(eventoCadastroDto.idEvento())
                .orElseThrow(() -> new EventoNaoExisteException("Evento não encontrado."));
        BeanUtils.copyProperties(eventoCadastroDto, evento);
        return new EventoExibicaoDto(eventoRepository.save(evento));
    }

    // Deleta um evento pelo ID
    @Transactional
    public void deletar(Long id) {
        Optional<Evento> eventoOptional = eventoRepository.findById(id);
        if (eventoOptional.isPresent()) {
            eventoRepository.delete(eventoOptional.get());
        } else {
            throw new EventoNaoExisteException("Evento não encontrado.");
        }
    }
}
