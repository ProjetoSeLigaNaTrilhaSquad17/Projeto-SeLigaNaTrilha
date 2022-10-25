package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.models.Tema;

import java.util.List;
import java.util.UUID;

public interface TemaService {

    List<Tema> findAll();

    void save(String novoTema);

    void update(UUID id, String novoTema);

    void delete(UUID id);
}
