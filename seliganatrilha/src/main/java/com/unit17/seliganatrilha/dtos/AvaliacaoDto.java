package com.unit17.seliganatrilha.dtos;

import javax.validation.constraints.NotBlank;

import com.unit17.seliganatrilha.models.Avaliacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoDto {
    
    String comentario;

    @NotBlank(message = "A nota tem que ser entre 1 e 5.")
    private int nota;

    public Avaliacao convertToAvaliacao(){
        return new Avaliacao(this.comentario, this.nota, null);
    } 
}
