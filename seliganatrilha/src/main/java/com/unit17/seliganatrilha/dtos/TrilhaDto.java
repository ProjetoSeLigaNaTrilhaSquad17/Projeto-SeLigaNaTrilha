package com.unit17.seliganatrilha.dtos;

import javax.validation.constraints.NotBlank;

import com.unit17.seliganatrilha.models.Trilha;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class TrilhaDto {
    @NotBlank(message  = "O nome não pode ser vazio.")
    private String nome;
    
    @NotBlank(message = "Digite uma breve descrição sobre a trilha.")
    private String descricao;

    @NotBlank(message = "A trilhar precisar conter temas")
    private List<UUID> temasId;

    public Trilha convertToTrilha(){
        return new Trilha(this.nome, this.descricao);
    }
}
