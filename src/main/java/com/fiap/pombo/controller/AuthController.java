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
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginDto loginDto){
        UsernamePasswordAuthenticationToken userNamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDto.nome(),
                        loginDto.senha()
                );

        // Autenticar o usuário
        Authentication auth = authenticationManager.authenticate(userNamePassword);

        // Apenas retorna uma mensagem de sucesso ou detalhes do usuário autenticado
        Usuario usuario = (Usuario) auth.getPrincipal();
        LoginResponseDto responseDto = new LoginResponseDto("Login bem-sucedido para: " + usuario.getUsername());
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto registrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        return service.salvar(usuarioCadastroDto);
    }

}