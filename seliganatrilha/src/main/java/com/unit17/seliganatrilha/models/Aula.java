package com.unit17.seliganatrilha.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Table(name = "TB_AULA")
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Aula {

    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column
    @NotBlank
    private String titulo;

    @Column(columnDefinition = "TEXT") //ColumnDefinition para o campo aceitar textos longos.
    @NotBlank
    private String texto;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aula")
    private List<Link> links = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "trilha_id")
    private Trilha trilha;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tb_tema_aula",
            joinColumns = { @JoinColumn(name = "aula_id") },
            inverseJoinColumns = { @JoinColumn(name = "tema_id")
            })
    private Set<Tema> temas = new HashSet<>();

    public Aula(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }
}
