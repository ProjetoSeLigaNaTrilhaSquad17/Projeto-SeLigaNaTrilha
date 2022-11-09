package com.unit17.seliganatrilha.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "TB_AVALIACAO")
@NoArgsConstructor
public class Avaliacao{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "comentario", columnDefinition = "TEXT") //ColumnDefinition para o campo aceitar textos longos.
    private String comentario;

    @Column(name = "nota", nullable = false)
    private int nota;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "trilha_id")
    private Trilha trilha;


    public Avaliacao(String comentario, int nota, Trilha trilha) {
        this.comentario = comentario;
        this.nota = nota;
        this.trilha = trilha;
    }
}
