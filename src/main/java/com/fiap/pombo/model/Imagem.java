package com.fiap.pombo.model;

import jakarta.persistence.*;

import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "T_IMAGEM")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagem")
    private Long idImagem;

    @ManyToOne
    @JoinColumn(name = "id_email", nullable = false)
    private Email email;

//    @Lob
//    @Column(name = "imagem")
//    private byte[] imagem;

    @Column(name = "descricao", length = 255)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

//    public byte[] getImagem() {
//        return imagem;
//    }
//
//    public void setImagem(byte[] imagem) {
//        this.imagem = imagem;
//    }

    public Email gethemeil() {
        return email;
    }

    public void sethemeil(Email email) {
        this.email = email;
    }

    public Long getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Long idImagem) {
        this.idImagem = idImagem;
    }
}
