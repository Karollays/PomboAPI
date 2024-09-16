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
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "contas", nullable = false)
    private String contas = "";

    // Campo adicionado para preferências
    @Column(name = "pf_theme", nullable = false)
    private boolean theme = false;

    @Column(name = "pf_colors", length = 255, nullable = false)
    private String colors = "";

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retorna uma lista de authorities. Se não houver roles específicas, retorne uma lista vazia.
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
