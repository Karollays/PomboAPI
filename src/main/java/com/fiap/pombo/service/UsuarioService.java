package com.fiap.pombo.service;


import com.fiap.pombo.dto.UsuarioCadastroDto;
import com.fiap.pombo.dto.UsuarioExibicaoDto;
import com.fiap.pombo.dto.UsuarioPrefCadastroDto;
import com.fiap.pombo.dto.UsuarioPrefExibicaoDto;
import com.fiap.pombo.exception.UsuarioNaoExisteException;
import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioExibicaoDto salvar(UsuarioCadastroDto usuarioCadastroDto) {

        // Criptografar a password
        String passwordCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.password());

        // Criar novo objeto Usuario
        Usuario usuario = new Usuario();

        // Copiar propriedades do DTO para a entidade
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);

        // Definir a password criptografada
        usuario.setPassword(passwordCriptografada);

        // Garante que os campos 'contas' e 'colors' nunca sejam nulos
        usuario.setContas(usuarioCadastroDto.contas() != null ? usuarioCadastroDto.contas() : "");
        usuario.setColors(usuarioCadastroDto.colors() != null ? usuarioCadastroDto.colors() : "");

        // Salvar o usuário no banco de dados
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        // Retornar DTO de exibição
        return new UsuarioExibicaoDto(usuarioSalvo);
    }

    @Transactional(readOnly = true)
    public UsuarioExibicaoDto buscar(Long id) {
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);


        if (usuarioOptional.isPresent()) {
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new UsuarioNaoExisteException("Usuário não encontrado.");
        }
    }

    @Transactional
    public UsuarioExibicaoDto atualizar(UsuarioCadastroDto usuarioCadastroDto) {

        Usuario usuario = usuarioRepository.findById(usuarioCadastroDto.id())
                .orElseThrow(() -> new UsuarioNaoExisteException("Usuário não encontrado."));
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        return new UsuarioExibicaoDto(usuarioRepository.save(usuario));
    }

    @Transactional
    public void deletar(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new UsuarioNaoExisteException("Usuário não encontrado.");
        }
    }

    @Transactional(readOnly = true)
    public Page<UsuarioExibicaoDto> listarUsuarios(Pageable paginacao) {
        return usuarioRepository
                .findAll(paginacao)
                .map(UsuarioExibicaoDto::new);
    }

    public UsuarioExibicaoDto buscarPorusername(String username) throws UsuarioNaoExisteException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsuarioNaoExisteException("Usuário não encontrado"));
        return new UsuarioExibicaoDto(usuario);
    }
}