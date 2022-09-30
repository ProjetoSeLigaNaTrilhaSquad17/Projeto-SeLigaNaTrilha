package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.UsuarioDto;
import com.unit17.seliganatrilha.models.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();

    void save(UsuarioDto novoUsuarioDto);

    void delete(Usuario usuarioDeletar);
}
