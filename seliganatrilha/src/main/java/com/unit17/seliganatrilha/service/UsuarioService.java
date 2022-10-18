package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.UsuarioPostDto;
import com.unit17.seliganatrilha.models.Usuario;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UsuarioService {

    List<Usuario> findAll();

    Usuario findById(UUID id);

    void save(UsuarioPostDto novoUsuarioPostDto);

    void update(UUID id, UsuarioPostDto novoUsuario);

    void delete(UUID id);

    Set<String> findTrilhas(UUID id);
}
