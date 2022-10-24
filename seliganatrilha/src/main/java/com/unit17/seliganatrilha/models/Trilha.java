package com.unit17.seliganatrilha.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unit17.seliganatrilha.dtos.AulaDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.*;

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
    private UUID idTrilha;

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

    public Trilha(String nome, String descricao, List<AulaDto> aulas) {
        this.nome = nome;
        this.descricao = descricao;
        this.aulas.addAll(aulas.stream().map(AulaDto::convertToAula).toList());
        this.status = false;
    }
}
