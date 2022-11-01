package com.unit17.seliganatrilha.dtos;

import com.unit17.seliganatrilha.models.Aula;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class AulaDto {

    @NotBlank
    private String titulo;

    @NotBlank
    private String texto;

    @NotBlank(message = "A trilhar precisar conter temas")
    private List<UUID> temasId;

    public Aula convertToAula(){
        return new Aula(this.titulo, this.texto);
    }
}
