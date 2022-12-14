package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.UsuarioDto;
import com.unit17.seliganatrilha.exceptions.UsuarioNaoEncontradoException;
import com.unit17.seliganatrilha.models.Trilha;
import com.unit17.seliganatrilha.models.Usuario;

import com.unit17.seliganatrilha.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    final UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

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

    @Override
    public Usuario findByEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException();
        }
        return usuario.get();
    }

    @Transactional
    public void save(UsuarioDto novoUsuarioDto) {
        String pass = novoUsuarioDto.getSenha();
        novoUsuarioDto.setSenha(encoder.encode(pass));
        usuarioRepository.save(novoUsuarioDto.convertToUsuario());
    }

    @Transactional
    public void update(UUID id, UsuarioDto novoUsuario) {
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
    public Set<Trilha> findTrilhas(UUID id) {
        return findById(id).getTrilhas();
    }

}
