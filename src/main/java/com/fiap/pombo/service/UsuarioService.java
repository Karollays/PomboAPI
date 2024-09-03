package com.fiap.pombo.service;


import com.fiap.pombo.dto.UsuarioCadastroDto;
import com.fiap.pombo.dto.UsuarioExibicaoDto;
import com.fiap.pombo.exception.UsuarioNaoExisteException;
import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        usuario.setSenha(senhaCriptografada);


        Usuario usuarioSalvo = usuarioRepository.save(usuario);


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
    public List<UsuarioExibicaoDto> listarUsuarios() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDto::new)
                .toList();
    }
}