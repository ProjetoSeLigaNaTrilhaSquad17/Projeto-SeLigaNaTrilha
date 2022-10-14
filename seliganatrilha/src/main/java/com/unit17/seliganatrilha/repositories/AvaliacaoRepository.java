package com.unit17.seliganatrilha.repositories;

import java.util.UUID;

import com.unit17.seliganatrilha.models.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, UUID>{
    
}
