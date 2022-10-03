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

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public void save(UsuarioDto novoUsuarioDto) {
        Usuario novoUsuario = new Usuario(
                novoUsuarioDto.getNome(),
                novoUsuarioDto.getEmail(),
                novoUsuarioDto.getCpf(),
                novoUsuarioDto.getSenha());
        usuarioRepository.save(novoUsuario);
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
