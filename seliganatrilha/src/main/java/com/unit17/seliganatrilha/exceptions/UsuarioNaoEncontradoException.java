package com.unit17.seliganatrilha.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException{
    public UsuarioNaoEncontradoException() {
        super("Usuário não encontrado");
    }
}
