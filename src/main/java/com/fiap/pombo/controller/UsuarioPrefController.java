package com.fiap.pombo.controller;

import com.fiap.pombo.dto.UsuarioCadastroDto;
import com.fiap.pombo.dto.UsuarioExibicaoDto;
import com.fiap.pombo.exception.UsuarioNaoExisteException;
import com.fiap.pombo.service.UsuarioPrefService;
import com.fiap.pombo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fiap.pombo.dto.UsuarioCadastroDto;
import com.fiap.pombo.dto.UsuarioExibicaoDto;
import com.fiap.pombo.dto.UsuarioPrefCadastroDto;
import com.fiap.pombo.dto.UsuarioPrefExibicaoDto;
import com.fiap.pombo.exception.UsuarioNaoExisteException;
import com.fiap.pombo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioPrefController {

    @Autowired
    private UsuarioPrefService usuarioPrefService;

    // Update an existing user's preferences
    @PutMapping("/usuariospref/{id}")
    public UsuarioPrefExibicaoDto atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioPrefCadastroDto usuarioPrefCadastroDto) {
        return usuarioPrefService.atualizar(id, usuarioPrefCadastroDto);
    }
}
