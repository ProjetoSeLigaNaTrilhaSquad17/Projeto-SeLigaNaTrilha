package com.unit17.seliganatrilha.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TrilhaDto {

    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "O email não pode ser vazio")
    private String comentario;

    @NotBlank(message = "O cpf não pode ser vazio")
    private String status;

}
