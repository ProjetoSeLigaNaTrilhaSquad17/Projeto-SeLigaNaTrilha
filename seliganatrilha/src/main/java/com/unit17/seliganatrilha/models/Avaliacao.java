package com.unit17.seliganatrilha.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "TB_AVALIACAO")
@NoArgsConstructor
public class Avaliacao {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "comentario", nullable = true)
    private String comentario;

    @Column(name = "nota", nullable = false)
    private int nota;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idTrilha", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Trilha trilha;

    public Avaliacao(String comentario, int nota, Trilha trilha) {
        this.comentario = comentario;
        this.nota = nota;
        this.trilha = trilha;
    }
}
