package com.unit17.seliganatrilha.repositories;

import com.unit17.seliganatrilha.models.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TemaRepository extends JpaRepository<Tema, UUID> {

    List<Tema> findTemasByTrilhasId(UUID trilhaId);

    List<Tema> findByNomeContaining(String nome);

}
