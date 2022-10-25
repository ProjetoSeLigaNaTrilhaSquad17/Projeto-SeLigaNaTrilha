package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.AulaDto;
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
    final LinkService linkService;

    public AulaServiceImpl(AulaRepository aulaRepository, LinkService linkService) {
        this.aulaRepository = aulaRepository;
        this.linkService = linkService;
    }


    @Override
    public Aula findById(UUID id) {
        Optional<Aula> aula = aulaRepository.findById(id);
        if(aula.isEmpty()) {
            throw new RuntimeException();
        }
        return aula.get();
    }

    @Transactional
    public void save(Trilha trilha, AulaDto novaAula) {
        Aula aula = novaAula.convertToAula();
        aula.setTrilha(trilha);
        aulaRepository.save(aula);
        novaAula.getLinks().forEach(link -> linkService.save(aula, link));
    }

    @Transactional
    public void update(UUID id, AulaDto novaAula) {

    }

    @Transactional
    public void delete(UUID id) {

    }
}
