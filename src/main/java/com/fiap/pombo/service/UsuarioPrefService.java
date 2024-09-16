package com.fiap.pombo.service;


import com.fiap.pombo.dto.UsuarioCadastroDto;
import com.fiap.pombo.dto.UsuarioExibicaoDto;
import com.fiap.pombo.dto.UsuarioPrefCadastroDto;
import com.fiap.pombo.dto.UsuarioPrefExibicaoDto;
import com.fiap.pombo.exception.UsuarioNaoExisteException;
import com.fiap.pombo.model.Usuario;
import com.fiap.pombo.repository.UsuarioPrefRepository;
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
public class UsuarioPrefService {

    @Autowired
    private UsuarioPrefRepository usuarioPrefRepository;


    @Transactional
    public UsuarioPrefExibicaoDto atualizar(Long id, UsuarioPrefCadastroDto usuarioPrefCadastroDto) {

        Usuario usuario = usuarioPrefRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExisteException("Usuário não encontrado."));

        // Atualizando apenas os campos theme e colors
        usuario.setTheme(usuarioPrefCadastroDto.theme());
        usuario.setColors(usuarioPrefCadastroDto.colors());

        return new UsuarioPrefExibicaoDto(usuarioPrefRepository.save(usuario));
    }



}
