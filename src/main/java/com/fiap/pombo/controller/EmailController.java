package com.fiap.pombo.controller;

import com.fiap.pombo.dto.EmailCadastroDto;
import com.fiap.pombo.dto.EmailExibicaoDto;
import com.fiap.pombo.dto.UsuarioExibicaoDto;
import com.fiap.pombo.exception.EmailNaoExisteException;
import com.fiap.pombo.model.Email;
import com.fiap.pombo.service.EmailService;
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
public class EmailController {

    @Autowired
    private EmailService emailService;
    private UsuarioService usuarioService;

    // Create a new email
    @PostMapping("/emails")
    @ResponseStatus(HttpStatus.CREATED)
    public EmailExibicaoDto salvar(@RequestBody @Valid EmailCadastroDto emailCadastroDto) {
        return emailService.salvar(emailCadastroDto);
    }

    // Get a list of all emails
    @GetMapping("/emails")
    @ResponseStatus(HttpStatus.OK)
    public Page<EmailExibicaoDto> listarEmail(Pageable paginacao) {
        return emailService.listarEmail(paginacao);
    }

    // Get a single email by ID
    @GetMapping("/emails/{idEmail}")
    public ResponseEntity<EmailExibicaoDto> buscar(@PathVariable Long idEmail) {
        try {
            EmailExibicaoDto email = emailService.buscar(idEmail);
            return new ResponseEntity<>(email, HttpStatus.OK);
        } catch (EmailNaoExisteException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


//    @GetMapping("/emails/{idEmail}")
//    @ResponseStatus(HttpStatus.OK)
//    public EmailExibicaoDto buscar(@PathVariable Long idEmail) {
//        return emailService.buscar(idEmail);
//    }

    // Update an existing email
    @PutMapping("/emails")
    public EmailExibicaoDto atualizar(@RequestBody @Valid EmailCadastroDto emailCadastroDto) {
        return emailService.atualizar(emailCadastroDto);
    }

    // Delete an email by ID
    @DeleteMapping("/emails/{idEmail}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long idEmail) {
        emailService.deletar(idEmail);
    }
}