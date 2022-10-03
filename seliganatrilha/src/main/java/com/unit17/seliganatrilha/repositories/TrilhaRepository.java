package com.unit17.seliganatrilha.repositories;

import java.util.UUID;

import com.unit17.seliganatrilha.models.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, UUID>{
    
}
