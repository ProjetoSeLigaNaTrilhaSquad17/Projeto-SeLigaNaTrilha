package com.unit17.seliganatrilha.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.Set;
import java.util.UUID;

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
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private String senha;
    
    // Relacionamento 0 - n
    //@NoneToMany(cascade = CascadeType.ALL)
    //private Set<Trilha> trilhaId; 

    public Usuario(String nome, String email, String cpf, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }
   
}