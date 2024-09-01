package com.fiap.pombo.model;

import jakarta.persistence.*;

import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "imagem")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagem")
    private Long idImagem;

    @ManyToOne
    @JoinColumn(name = "id_email", nullable = false)
    private Email email;

    @Lob
    @Column(name = "imagem")
    private byte[] imagem;

    @Column(name = "descricao", length = 255)
    private String descricao;
}
