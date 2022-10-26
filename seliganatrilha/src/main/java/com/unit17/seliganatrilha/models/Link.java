package com.unit17.seliganatrilha.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TB_LINK")
@Getter
@Setter
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column
    private String link;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    public Link(String link) {
        this.link = link;
    }
}
