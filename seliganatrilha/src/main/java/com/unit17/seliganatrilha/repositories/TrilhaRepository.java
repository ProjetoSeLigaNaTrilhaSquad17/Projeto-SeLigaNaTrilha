package com.unit17.seliganatrilha.repositories;

import com.unit17.seliganatrilha.models.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, UUID>{

    List<Trilha> findByNomeContaining(String name);
}