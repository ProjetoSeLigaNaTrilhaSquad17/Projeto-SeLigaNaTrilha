package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.models.Aula;
import com.unit17.seliganatrilha.models.Tema;
import com.unit17.seliganatrilha.models.Trilha;

import java.util.List;
import java.util.UUID;

public interface TemaService {

    List<Tema> findAll();

    Tema findById(UUID id);

    List<Tema> findByNome(String nome);

    List<Aula> findAulas(UUID id);

    List<Trilha> findTrilhas(UUID id);

    void save(String novoTema);

    void update(UUID id, String novoTema);

    void delete(UUID id);
}
