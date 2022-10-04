package com.unit17.seliganatrilha.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

@Entity
@Table(name = "TB_TRILHA")
public class Trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID idTrilha;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false, unique = true)
    private String comentario;
    @Column(nullable = false, unique = true)
    private String status;
    
    public Trilha() {
    }

    public Trilha(UUID idcurso, String nome, String comentario) {
        this.idTrilha = idcurso;
        this.nome = nome;
        this.comentario = comentario;
        this.status = "A_VALIDAR";
    }

}
