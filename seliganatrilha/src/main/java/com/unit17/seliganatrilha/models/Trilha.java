package com.unit17.seliganatrilha.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unit17.seliganatrilha.dtos.AulaDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "TB_TRILHA")
@Getter
@Setter
@NoArgsConstructor
public class Trilha {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private Boolean status;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trilha")
    private Set<Avaliacao> avaliacoes = new HashSet<>();

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trilha")
    private List<Aula> aulas = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "trilhas")
    @JsonIgnore
    private Set<Tema> temas = new HashSet<>();

    public Trilha(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = false;
    }
}
