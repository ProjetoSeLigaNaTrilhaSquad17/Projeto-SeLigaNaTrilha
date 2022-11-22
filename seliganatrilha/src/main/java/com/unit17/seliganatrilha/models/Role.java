package com.unit17.seliganatrilha.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "TB_ROLE")
public class Role {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;
}
