package com.fiap.pombo.controller;

import com.fiap.pombo.dto.LoginDto;
import com.fiap.pombo.dto.LoginResponseDto;
import com.fiap.pombo.dto.UsuarioCadastroDto;
import com.fiap.pombo.dto.UsuarioExibicaoDto;
import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody @Valid LoginDto loginDto){
        UsernamePasswordAuthenticationToken userNamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDto.nome(),
                        loginDto.senha()
                );

        // Autenticar o usuário
        Authentication auth = authenticationManager.authenticate(userNamePassword);

        // Apenas retorna o status 200 (OK) sem mensagem JSON
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto registrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        return service.salvar(usuarioCadastroDto);
    }

}