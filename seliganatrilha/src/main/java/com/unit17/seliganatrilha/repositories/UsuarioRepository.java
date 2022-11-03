package com.unit17.seliganatrilha.repositories;
import org.springframework.data.jpa.repository.Query;

import com.unit17.seliganatrilha.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    @Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.email= (:email)")
    public Usuario findByEmail(@Param("email") String email);
    boolean existsByEmail(String Email);
}