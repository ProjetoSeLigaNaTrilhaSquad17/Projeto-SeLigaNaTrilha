package com.unit17.seliganatrilha.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrilhaDto {
    @NotBlank(message  = "O nome não pode ser vazio.")
    private String nome;
    
    @NotBlank(message = "Digite ao menos um breve comentário sobre a trilha.")
    private String comentario;
    
    @NotBlank(message = "O status não pode ser vazio")
    private String status;
}
