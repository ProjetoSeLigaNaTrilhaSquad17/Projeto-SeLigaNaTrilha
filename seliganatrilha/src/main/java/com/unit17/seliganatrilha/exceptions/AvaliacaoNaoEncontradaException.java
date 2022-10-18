package com.unit17.seliganatrilha.exceptions;

public class AvaliacaoNaoEncontradaException extends RuntimeException{
    public AvaliacaoNaoEncontradaException(){
        super("Avaliação não encontrada");
    }
}