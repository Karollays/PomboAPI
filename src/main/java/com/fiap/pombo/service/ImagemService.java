package com.fiap.pombo.service;

import com.fiap.pombo.model.Imagem;
import com.fiap.pombo.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository imagemRepository;

    // Salva uma nova imagem
    public Imagem saveImagem(Imagem imagem) {
        return imagemRepository.save(imagem);
    }

    // Retorna todas as imagens
    public List<Imagem> getAllImagens() {
        return imagemRepository.findAll();
    }

    // Retorna uma imagem pelo ID
    public Imagem getImagemById(Long id) {
        Optional<Imagem> imagem = imagemRepository.findById(id);
        return imagem.orElse(null);
    }

    // Atualiza uma imagem existente
    public Imagem updateImagem(Long id, Imagem imagemDetails) {
        Optional<Imagem> optionalImagem = imagemRepository.findById(id);
        if (optionalImagem.isPresent()) {
            Imagem existingImagem = optionalImagem.get();
            existingImagem.setDescricao(imagemDetails.getDescricao());
//            existingImagem.setImagem(imagemDetails.getImagem());
            return imagemRepository.save(existingImagem);
        } else {
            return null;
        }
    }

    // Deleta uma imagem pelo ID
    public boolean deleteImagem(Long id) {
        if (imagemRepository.existsById(id)) {
            imagemRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
