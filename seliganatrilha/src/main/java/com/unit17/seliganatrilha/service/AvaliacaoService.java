package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.models.Avaliacao;
import com.unit17.seliganatrilha.dtos.AvaliacaoDto;

import java.util.List;
import java.util.UUID;

public interface AvaliacaoService {
    List<Avaliacao> findAll();

    void save(AvaliacaoDto novaAvaliacaoDto);

    void update(UUID id, AvaliacaoDto avaliacaoAtualiza);

    void delete(UUID id);
}
