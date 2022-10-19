package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.TrilhaDto;
import com.unit17.seliganatrilha.models.Avaliacao;
import com.unit17.seliganatrilha.models.Trilha;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface TrilhaService {

    List<Trilha> findAll();

    void save(TrilhaDto novaTrilhaDto, UUID id);

    void update(UUID id, TrilhaDto novoaTrilha);

    void delete(UUID id);

    Trilha findById(UUID id);

    Set<Avaliacao> findAvaliacoes(UUID id);
}
