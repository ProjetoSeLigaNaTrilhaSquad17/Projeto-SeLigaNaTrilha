package com.unit17.seliganatrilha.repositories;

import com.unit17.seliganatrilha.models.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AulaRepository extends JpaRepository<Aula, UUID> {
}
