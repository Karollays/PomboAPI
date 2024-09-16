package com.fiap.pombo.service;

import com.fiap.pombo.dto.EmailCadastroDto;
import com.fiap.pombo.dto.EmailExibicaoDto;
import com.fiap.pombo.exception.EmailNaoExisteException;
import com.fiap.pombo.model.Email;
import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.repository.EmailRepository;
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
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Salva um novo email no banco de dados
    @Transactional
    public EmailExibicaoDto salvar(EmailCadastroDto emailCadastroDto) {
        // Verificar se o idUsuario no DTO não é nulo
//        if (emailCadastroDto.idUsuario() == null) {
//            throw new IllegalArgumentException("O ID do usuário não pode ser nulo.");
//        }
//
//        // Encontrar o usuário pelo ID fornecido no DTO
//        Usuario usuario = usuarioRepository.findById(emailCadastroDto.idUsuario())
//                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        // Criar a nova instância de Email
        Email email = new Email();
        email.setDeEmail(emailCadastroDto.deEmail());
        email.setParaEmail(emailCadastroDto.paraEmail());
        email.setAssunto(emailCadastroDto.assunto());
        email.setcolorspo(emailCadastroDto.colorspo());
        email.setDataEmail(emailCadastroDto.dataEmail());
        email.setSpam(emailCadastroDto.spam());

        // Associar o usuário ao email
//        email.setUsuario(usuario);

        // Salvar e retornar o DTO de resposta
        return new EmailExibicaoDto(emailRepository.save(email));
    }

    // Retorna todos os emails cadastrados
    @Transactional(readOnly = true)
    public Page<EmailExibicaoDto> listarEmail(Pageable paginacao) {
        return emailRepository
                .findAll(paginacao)
                .map(EmailExibicaoDto::new);
    }

    // Retorna um email pelo ID
    @Transactional(readOnly = true)
    public EmailExibicaoDto buscar(Long idEmail) {
        Optional<Email> emailOptional = emailRepository.findById(idEmail);
        if (emailOptional.isPresent()) {
            return new EmailExibicaoDto(emailOptional.get());
        } else {
            throw new EmailNaoExisteException("Email não encontrado.");
        }
    }

    // Atualiza um email existente pelo ID
    @Transactional
    public EmailExibicaoDto atualizar(EmailCadastroDto emailCadastroDto) {
        Email email = emailRepository.findById(emailCadastroDto.idEmail())
                .orElseThrow(() -> new EmailNaoExisteException("Email não encontrado."));
        BeanUtils.copyProperties(emailCadastroDto, email);
        return new EmailExibicaoDto(emailRepository.save(email));
    }

    // Deleta um email pelo ID
    @Transactional
    public void deletar(Long id) {
        Optional<Email> emailOptional = emailRepository.findById(id);
        if (emailOptional.isPresent()) {
            emailRepository.delete(emailOptional.get());
        } else {
            throw new EmailNaoExisteException("Email não encontrado.");
        }
    }
}
