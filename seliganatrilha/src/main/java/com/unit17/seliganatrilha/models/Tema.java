package com.unit17.seliganatrilha.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TB_TEMA")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column
    @NotBlank
    private String nome;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "temas")
    private List<Aula> aulas = new ArrayList<>();

    public Tema(String nome) {
        this.nome = nome;
    }
}
