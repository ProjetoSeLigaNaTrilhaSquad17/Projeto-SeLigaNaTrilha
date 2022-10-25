package com.unit17.seliganatrilha.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tb_tema_trilha",
            joinColumns = { @JoinColumn(name = "tema_id") },
            inverseJoinColumns = { @JoinColumn(name = "trilha_id")
    })
    private Set<Trilha> trilhas = new HashSet<>();

    public Tema(String nome) {
        this.nome = nome;
    }
}
