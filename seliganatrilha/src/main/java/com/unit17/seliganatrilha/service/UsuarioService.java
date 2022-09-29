package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.models.Usuario;
import com.unit17.seliganatrilha.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService {

    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public void save(Usuario novoUsuario) {
        usuarioRepository.save(novoUsuario);
    }

    @Transactional
    public void delete(Usuario usuarioDeletar) {
        usuarioRepository.delete(usuarioDeletar);
    }
}
