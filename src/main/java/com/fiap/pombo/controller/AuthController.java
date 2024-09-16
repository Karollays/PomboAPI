package com.fiap.pombo.controller;


import com.fiap.pombo.dto.LoginResponseDto;
import com.fiap.pombo.dto.LoginDto;
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
    public ResponseEntity<UsuarioExibicaoDto> login(@RequestBody @Valid LoginDto loginDto) {
        UsernamePasswordAuthenticationToken userNamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDto.username(),
                        loginDto.password()
                );

        // Autenticar o usuário
        Authentication auth = authenticationManager.authenticate(userNamePassword);

        // Recuperar o usuário autenticado
        Usuario usuario = (Usuario) auth.getPrincipal();

        // Garante que os campos 'contas' e 'colors' não retornem como nulos ou vazios
        String contas = usuario.getContas() != null ? usuario.getContas() : "";
        String colors = usuario.getColors() != null ? usuario.getColors() : "";

        // Criar o DTO de exibição do usuário autenticado
        UsuarioExibicaoDto responseDto = new UsuarioExibicaoDto(
                usuario.getId_usuario(),
                usuario.getUsername(),
                usuario.getPassword(),
                contas,  // Garante que não seja vazio
                usuario.isTheme(),
                colors      // Garante que não seja vazio
        );

        // Retornar o DTO com as informações do usuário autenticado
        return ResponseEntity.ok(responseDto);
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto registrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        return service.salvar(usuarioCadastroDto);
    }

}