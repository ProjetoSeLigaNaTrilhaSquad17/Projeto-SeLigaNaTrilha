package com.unit17.seliganatrilha.dtos;

import javax.validation.constraints.NotBlank;

import com.unit17.seliganatrilha.models.Avaliacao;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.UUID;

@Getter
@Setter
public class AvaliacaoDto {
    
    String comentario;

    @NotBlank
    @Range(min = 0, max = 5, message = "A nota tem que ser entre 1 e 5.")
    private int nota;

    public Avaliacao convertToAvaliacao(){
        return new Avaliacao(this.comentario, this.nota, null);
    } 
}
