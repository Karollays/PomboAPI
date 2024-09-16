package com.fiap.pombo.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "TBL_EVENT")
public class Evento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_T_EVENTO")
    @SequenceGenerator(
            name = "SEQ_T_EVENTO",
            sequenceName = "SEQ_T_EVENTO",
            allocationSize = 1)


    @Column(name = "id_evento")
    private Long idEvento;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

//    @ManyToOne
//    @JoinColumn(name = "id_email", nullable = false)
//    private Email email;

    @Column(name = "titulo", length = 255)
    private String titulo;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_inicial")
    private Date dataInicial;

    @Column(name = "hr_inicial")
    private Timestamp horaInicial;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_final")
    private Date dataFinal;

    @Column(name = "hr_final")
    private Timestamp horaFinal;


    @Column(name = "localizacao", length = 255)
    private String localizacao;

    @Column(name = "descricao")
    private String descricao;

//    public Email gethemeil() {
//        return email;
//    }
//
//    public void sethemeil(Email email) {
//        this.email = email;
//    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Timestamp getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Timestamp horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Timestamp getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Timestamp horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}
}