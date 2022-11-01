package com.unit17.seliganatrilha.service;


import java.util.UUID;

public interface LinkService {

    void save(UUID aulaId, String novoLink);

    void update(UUID id, String novoLink);

    void delete(UUID id);
}
