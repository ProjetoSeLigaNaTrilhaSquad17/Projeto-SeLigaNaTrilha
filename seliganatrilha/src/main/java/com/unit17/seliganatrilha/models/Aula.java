package com.unit17.seliganatrilha.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unit17.seliganatrilha.dtos.LinkDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Table
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

    @Column
    @NotBlank
    private String texto;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aula")
    private List<Link> links = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "trilha_id")
    private Trilha trilha;

    public Aula(String titulo, String texto, List<LinkDto> links) {
        this.titulo = titulo;
        this.texto = texto;
        this.links.addAll(links.stream().map(LinkDto::convertToLink).toList());
    }
}
