package com.unit17.seliganatrilha.exceptions;

public class TemaNaoEncontradoException extends RuntimeException{
    public TemaNaoEncontradoException() {
        super("Tema não encontrado");
    }
}
