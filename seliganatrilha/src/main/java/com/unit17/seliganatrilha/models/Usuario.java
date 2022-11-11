package com.unit17.seliganatrilha.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "TB_USUARIO")
@NoArgsConstructor
public class Usuario{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String senha;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Set<Trilha> trilhas = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TB_USUARIO_ROLES", joinColumns = @JoinColumn(name = "USER_ID"))
    
    @Column(name = "ROLE_ID", nullable = false)
    private List<String> roles = new ArrayList<>();

    public Usuario(String nome, String email, String cpf, String senha, List <String> roles) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        roles.stream().map(i ->this.roles.add(i));
    }
}