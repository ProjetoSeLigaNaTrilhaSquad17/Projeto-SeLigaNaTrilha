package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.models.Tema;
import com.unit17.seliganatrilha.models.Trilha;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface TemaService {

    List<Tema> findAll();

    Tema findById(UUID id);

    Set<Trilha> findTrilhas(UUID id);

    void save(String novoTema);

    void update(UUID id, String novoTema);

    void delete(UUID id);
}
