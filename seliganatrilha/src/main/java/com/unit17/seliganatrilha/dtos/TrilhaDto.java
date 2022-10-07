package com.unit17.seliganatrilha.dtos;

import javax.validation.constraints.NotBlank;

import com.unit17.seliganatrilha.models.Trilha;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrilhaDto {
    @NotBlank(message  = "O nome não pode ser vazio.")
    private String nome;
    
    @NotBlank(message = "Digite ao menos um breve comentário sobre a trilha.")
    private String comentario;

    public Trilha convertToTrilha(){
        return new Trilha(this.nome, this.comentario);
    }
}
