package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.AulaDto;
import com.unit17.seliganatrilha.models.Aula;
import com.unit17.seliganatrilha.models.Trilha;

import java.util.List;
import java.util.UUID;

public interface AulaService {

    Aula findById(UUID id);

    void save(UUID trilhaId, AulaDto novaAula);

    void update(UUID id, AulaDto novaAula);

    void delete(UUID id);
}
