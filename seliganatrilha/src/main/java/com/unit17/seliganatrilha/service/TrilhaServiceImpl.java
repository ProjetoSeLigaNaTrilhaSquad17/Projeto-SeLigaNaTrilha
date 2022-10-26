package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.TrilhaDto;
import com.unit17.seliganatrilha.exceptions.TrilhaNaoEncontradaException;
import com.unit17.seliganatrilha.models.Avaliacao;
import com.unit17.seliganatrilha.models.Trilha;
import com.unit17.seliganatrilha.models.Usuario;
import com.unit17.seliganatrilha.repositories.TrilhaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class TrilhaServiceImpl implements TrilhaService {

    final TrilhaRepository trilhaRepository;
    final UsuarioService usuarioService;
    final TemaService temaService;

    public TrilhaServiceImpl(TrilhaRepository trilhaRepository, UsuarioService usuarioService, TemaService temaService) {
        this.trilhaRepository = trilhaRepository;
        this.usuarioService = usuarioService;
        this.temaService = temaService;
    }

    public List<Trilha> findAll() {
        return trilhaRepository.findAll();
    }

    @Transactional
    public void save(TrilhaDto novaTrilhaDto, UUID usuarioId) {
        Usuario usuario = usuarioService.findById(usuarioId);
        Trilha trilha = novaTrilhaDto.convertToTrilha();
        trilha.setUsuario(usuario);
        novaTrilhaDto.getTemasId().forEach(temaId -> trilha.getTemas().add(temaService.findById(temaId)));
        trilhaRepository.save(trilha);
    }

    @Transactional
    public void update(UUID id, TrilhaDto novaTrilha) {
        Optional<Trilha> trilha = trilhaRepository.findById(id);
        if(trilha.isEmpty()) {
            throw new TrilhaNaoEncontradaException();
        }
        Trilha antigaTrilha = trilha.get();
        antigaTrilha.setNome(novaTrilha.getNome());
        antigaTrilha.setDescricao(novaTrilha.getDescricao());
    }

    @Transactional
    public void delete(UUID id) {
        if(trilhaRepository.findById(id).isEmpty()) {
            throw new TrilhaNaoEncontradaException();
        }
        trilhaRepository.deleteById(id);
    }

    @Override
    public Trilha findById(UUID id) {
        Optional<Trilha> trilha = trilhaRepository.findById(id);
        if(trilha.isEmpty()) {
            throw new TrilhaNaoEncontradaException();
        }
        return trilha.get();
    }

    @Override
    public Set<Avaliacao> findAvaliacoes(UUID id) {
        return findById(id).getAvaliacoes();
    }

    @Override
    public Boolean existsById(UUID id) {
        return trilhaRepository.existsById(id);
    }
}
