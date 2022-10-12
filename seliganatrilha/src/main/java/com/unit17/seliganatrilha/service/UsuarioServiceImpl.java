package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.UsuarioDto;
import com.unit17.seliganatrilha.exceptions.UsuarioNaoEncontradoException;
import com.unit17.seliganatrilha.models.Usuario;
import com.unit17.seliganatrilha.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public void save(UsuarioDto novoUsuarioDto) {
        usuarioRepository.save(novoUsuarioDto.convertToUsuario());
    }

    @Transactional
    public void update(UUID id, UsuarioDto novoUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException();
        }
        Usuario antigoUsuario = usuario.get();
        antigoUsuario.setNome(novoUsuario.getNome());
        antigoUsuario.setEmail(novoUsuario.getEmail());
        antigoUsuario.setCpf(novoUsuario.getCpf());
        antigoUsuario.setSenha(novoUsuario.getSenha());
    }

    @Transactional
    public void delete(UUID id) {
        if(usuarioRepository.findById(id).isEmpty()) {
            throw new UsuarioNaoEncontradoException();
        }
        usuarioRepository.deleteById(id);
    }
}
