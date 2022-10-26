package com.unit17.seliganatrilha.dtos;

import com.unit17.seliganatrilha.models.Aula;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AulaDto {

    private String titulo;

    private String texto;

    public Aula convertToAula(){
        return new Aula(this.titulo, this.texto);
    }
}
