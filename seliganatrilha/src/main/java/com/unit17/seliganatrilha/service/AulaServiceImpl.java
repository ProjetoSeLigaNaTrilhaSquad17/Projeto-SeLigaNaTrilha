package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.AulaDto;
import com.unit17.seliganatrilha.exceptions.AulaNaoEncontradaException;
import com.unit17.seliganatrilha.models.Aula;
import com.unit17.seliganatrilha.models.Trilha;
import com.unit17.seliganatrilha.repositories.AulaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class AulaServiceImpl implements AulaService{

    final AulaRepository aulaRepository;
    final TrilhaService trilhaService;
    final TemaService temaService;

    public AulaServiceImpl(AulaRepository aulaRepository, TrilhaService trilhaService, TemaService temaService) {
        this.aulaRepository = aulaRepository;
        this.trilhaService = trilhaService;
        this.temaService = temaService;
    }


    @Override
    public Aula findById(UUID id) {
        Optional<Aula> aula = aulaRepository.findById(id);
        if(aula.isEmpty()) {
            throw new AulaNaoEncontradaException();
        }
        return aula.get();
    }

    @Transactional
    public void save(UUID trilhaId, AulaDto novaAula) {
        Trilha trilha = trilhaService.findById(trilhaId);
        Aula aula = novaAula.convertToAula();
        aula.setTrilha(trilha);
        novaAula.getTemasId().forEach(temaId -> aula.getTemas().add(temaService.findById(temaId)));
        aulaRepository.save(aula);
    }

    @Transactional
    public void update(UUID id, AulaDto novaAula) {
        Optional<Aula> aula = aulaRepository.findById(id);
        if(aula.isEmpty()) {
            throw  new RuntimeException();
        }
        Aula antigaAula = aula.get();
        antigaAula.setTexto(novaAula.getTexto());
        antigaAula.setTitulo(novaAula.getTitulo());
        antigaAula.getTemas().clear();
        novaAula.getTemasId().forEach(temaId -> antigaAula.getTemas().add(temaService.findById(temaId)));
    }

    @Transactional
    public void delete(UUID id) {
        if(!aulaRepository.existsById(id)) {
            throw  new RuntimeException();
        }
        aulaRepository.deleteById(id);
    }
}
