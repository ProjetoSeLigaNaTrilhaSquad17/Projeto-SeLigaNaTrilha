package com.unit17.seliganatrilha.exceptions;

public class AulaNaoEncontradaException extends RuntimeException{
    public AulaNaoEncontradaException() {
        super("Aula não encontrada");
    }
}
