package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.UsuarioPostDto;
import com.unit17.seliganatrilha.exceptions.UsuarioNaoEncontradoException;
import com.unit17.seliganatrilha.models.Trilha;
import com.unit17.seliganatrilha.models.Usuario;
import com.unit17.seliganatrilha.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(UUID id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException();
        }
        return usuario.get();
    }

    @Transactional
    public void save(UsuarioPostDto novoUsuarioPostDto) {
        usuarioRepository.save(novoUsuarioPostDto.convertToUsuario());
    }

    @Transactional
    public void update(UUID id, UsuarioPostDto novoUsuario) {
        Usuario antigoUsuario = findById(id);
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

    @Override
    public Set<String> findTrilhas(UUID id) {
        return findById(id).getTrilhas().stream().map(Trilha::getNome).collect(Collectors.toSet());
    }
}
