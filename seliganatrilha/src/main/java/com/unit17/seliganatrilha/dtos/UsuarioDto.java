package com.unit17.seliganatrilha.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioDto {

    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "O email não pode ser vazio")
    private String email;

    @NotBlank(message = "O cpf não pode ser vazio")
    private String cpf;

    @Size(min = 4, message = "A senha precisa ter no mínimo 4 caracteres")
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}