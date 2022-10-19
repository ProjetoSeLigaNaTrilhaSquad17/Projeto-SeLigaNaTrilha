package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.UsuarioDto;
import com.unit17.seliganatrilha.models.Avaliacao;
import com.unit17.seliganatrilha.models.Trilha;
import com.unit17.seliganatrilha.models.Usuario;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UsuarioService {

    List<Usuario> findAll();

    Usuario findById(UUID id);

    void save(UsuarioDto novoUsuarioDto);

    void update(UUID id, UsuarioDto novoUsuario);

    void delete(UUID id);

    Set<Trilha> findTrilhas(UUID id);

}
