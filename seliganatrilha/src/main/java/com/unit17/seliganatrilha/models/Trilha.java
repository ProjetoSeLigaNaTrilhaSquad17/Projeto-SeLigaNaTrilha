package com.unit17.seliganatrilha.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.UUID;

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

    //Relacionamento n - 1
    //@ManyToOne
    //@JoinColumn(name = "Usuario_id")
    //Usuario usuarioId;
    public Trilha(String nome, String comentario, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = false;
    }
}
