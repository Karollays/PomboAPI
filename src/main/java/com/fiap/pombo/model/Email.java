package com.fiap.pombo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Clob;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "TBL_EMAIL")
public class Email {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_T_EMAIL")
    @SequenceGenerator(
            name = "SEQ_T_EMAIL",
            sequenceName = "SEQ_T_EMAIL",
            allocationSize = 1)



    @Column(name ="id_email")
    private Long idEmail;

//    @ManyToOne
//    @JoinColumn(name = "id_usuario", nullable = false)
//    private Usuario usuario;

    @NotNull
    @Column(name = "de_email", nullable = false, length = 255)
    private String deEmail;

    @Column(name = "para_email", nullable = false, length = 255)
    private String paraEmail;

    @Column(name = "assunto", length = 255)
    private String assunto;

    @Column(name = "colorspo", nullable = false, length = 4000)
    private String colorspo;

//    @Lob
//    @Column(name = "colorspo")
//    private Clob colorspo;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_email")
    private Date dataEmail;

    @Column(name = "spam", nullable = false)
    private boolean spam = false;

//    @OneToMany(mappedBy = "email", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Imagem> imagens;

//    @OneToMany(mappedBy = "email", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Evento> eventos;

    public Long getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Long idEmail) {
        this.idEmail = idEmail;
    }

//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }

    public String getDeEmail() {
        return deEmail;
    }

    public void setDeEmail(String deEmail) {
        this.deEmail = deEmail;
    }

    public String getParaEmail() {
        return paraEmail;
    }

    public void setParaEmail(String paraEmail) {
        this.paraEmail = paraEmail;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getcolorspo() {return colorspo;}

    public void setcolorspo(String colorspo) {this.colorspo = colorspo;}



//    public Clob getcolorspo() {
//        return colorspo;
//    }
//
//    public void setcolorspo(Clob colorspo) {
//        this.colorspo = colorspo;
//    }

    public Date getDataEmail() {
        return dataEmail;
    }

    public void setDataEmail(Date dataEmail) {
        this.dataEmail = dataEmail;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

//    public List<Imagem> getImagens() {
//        return imagens;
//    }
//
//    public void setImagens(List<Imagem> imagens) {
//        this.imagens = imagens;
//    }
//
//    public List<Evento> getEventos() {
//        return eventos;
//    }
//
//    public void setEventos(List<Evento> eventos) {
//        this.eventos = eventos;
//    }
}
