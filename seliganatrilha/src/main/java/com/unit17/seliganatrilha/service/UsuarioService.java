package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.UsuarioDto;
import com.unit17.seliganatrilha.models.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

    List<Usuario> findAll();

    void save(UsuarioDto novoUsuarioDto);

    void update(UUID id, UsuarioDto novoUsuario);

    void delete(UUID id);
}
