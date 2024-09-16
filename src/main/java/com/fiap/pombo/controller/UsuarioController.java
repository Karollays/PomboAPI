package com.fiap.pombo.controller;

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
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Create a new user
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto salvar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto) {
        return usuarioService.salvar(usuarioCadastroDto);
    }

    // Get a list of all users
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Page<UsuarioExibicaoDto> listarUsuarios(Pageable paginacao) {
        return usuarioService.listarUsuarios(paginacao);
    }

    // Get a single user by ID
    @GetMapping("/users/{idUsuario}")
    public ResponseEntity<UsuarioExibicaoDto> buscar(@PathVariable Long idUsuario) {
        try {
            UsuarioExibicaoDto usuario = usuarioService.buscar(idUsuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (UsuarioNaoExisteException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Procurar por username de usuario
//    @GetMapping("/users/search/{username}")
//    public ResponseEntity<UsuarioExibicaoDto> buscarPorusername(@PathVariable String username) {
//
//        try {
//            UsuarioExibicaoDto usuario = usuarioService.buscarPorusername(username);
//            return new ResponseEntity<>(usuario, HttpStatus.OK);
//        } catch (UsuarioNaoExisteException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
//
//
//    }

    @GetMapping("/search")
    public ResponseEntity<UsuarioExibicaoDto> buscarPorusername(@RequestParam String username) {
        try {
            UsuarioExibicaoDto usuario = usuarioService.buscarPorusername(username);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (UsuarioNaoExisteException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Update an existing user
    @PutMapping("/users")
    public UsuarioExibicaoDto atualizar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto) {
        return usuarioService.atualizar(usuarioCadastroDto);
    }

    // Delete a user by ID
    @DeleteMapping("/users/{idUsuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long idUsuario) {
        usuarioService.deletar(idUsuario);
    }
}
