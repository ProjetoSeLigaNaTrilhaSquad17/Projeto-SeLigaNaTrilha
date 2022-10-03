package com.unit17.seliganatrilha.models;

import javax.persistence.*;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_TRILHA")
@Getter
@Setter
@AllArgsConstructor
public class Trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idcurso;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false, unique = true)
    private String comentario;
    @Column(nullable = false, unique = true)
    private String status;
}
