package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.models.Aula;
import com.unit17.seliganatrilha.models.Link;

import java.util.List;
import java.util.UUID;

public interface LinkService {

    void save(Aula aula, String novoLink);

    void update(UUID id, String novoLink);

    void delete(UUID id);
}
