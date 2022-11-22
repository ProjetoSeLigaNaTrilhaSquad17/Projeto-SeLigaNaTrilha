package com.unit17.seliganatrilha.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.unit17.seliganatrilha.models.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuarioDto {

    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "O email não pode ser vazio")
    private String email;

    @NotBlank(message = "O cpf não pode ser vazio")
    private String cpf;

    @Size(min = 4, message = "A senha precisa ter no mínimo 4 caracteres")
    private String senha;

    @NotBlank
    private String roles;

    public Usuario convertToUsuario(){
        return new Usuario(this.nome, this.email, this.cpf, this.senha,this.roles);
    }
}
