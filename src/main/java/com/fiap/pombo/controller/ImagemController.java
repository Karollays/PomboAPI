package com.fiap.pombo.controller;

import com.fiap.pombo.model.Imagem;
import com.fiap.pombo.service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagens")
public class ImagemController {

    @Autowired
    private ImagemService imagemService;

    // Criar uma nova imagem
    @PostMapping
    public ResponseEntity<Imagem> createImagem(@RequestBody Imagem imagem) {
        Imagem savedImagem = imagemService.saveImagem(imagem);
        return ResponseEntity.ok(savedImagem);
    }

    // Obter todas as imagens
    @GetMapping
    public ResponseEntity<List<Imagem>> getAllImagens() {
        List<Imagem> imagens = imagemService.getAllImagens();
        return ResponseEntity.ok(imagens);
    }

    // Obter uma imagem específica pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Imagem> getImagemById(@PathVariable Long id) {
        Imagem imagem = imagemService.getImagemById(id);
        if (imagem != null) {
            return ResponseEntity.ok(imagem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Atualizar uma imagem existente
    @PutMapping("/{id}")
    public ResponseEntity<Imagem> updateImagem(@PathVariable Long id, @RequestBody Imagem imagemDetails) {
        Imagem updatedImagem = imagemService.updateImagem(id, imagemDetails);
        if (updatedImagem != null) {
            return ResponseEntity.ok(updatedImagem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar uma imagem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImagem(@PathVariable Long id) {
        boolean deleted = imagemService.deleteImagem(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
