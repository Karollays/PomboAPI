package com.fiap.pombo.controller;

import com.fiap.pombo.config.security.TokenService;
import com.fiap.pombo.dto.LoginDto;
import com.fiap.pombo.dto.TokenDto;
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

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginDto){
        UsernamePasswordAuthenticationToken userNamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDto.email(),
                        loginDto.senha()
                );
        Authentication auth = authenticationManager.authenticate(userNamePassword);

        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDto(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto registrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        UsuarioExibicaoDto usuarioSalvo = null;
        usuarioSalvo = service.salvar(usuarioCadastroDto);
        return usuarioSalvo;

    }

}
