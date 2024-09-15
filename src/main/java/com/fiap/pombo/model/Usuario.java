package com.fiap.pombo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "TBL_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_T_USUARIO")
    @SequenceGenerator(
            name = "SEQ_T_USUARIO",
            sequenceName = "SEQ_T_USUARIO",
            allocationSize = 1)

    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nm_usuario")
    private String nome;

    @Column(name = "senha")
    private String senha;

    @Column(name = "contas")
    private String contas;

    // Campo adicionado para preferências
    @Column(name = "pf_tema", nullable = false)
    private boolean tema = false;

    @Column(name = "pf_cor", length = 255)
    private String cor;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retorna uma lista de authorities. Se não houver roles específicas, retorne uma lista vazia.
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
