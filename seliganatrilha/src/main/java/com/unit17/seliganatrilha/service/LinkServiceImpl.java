package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.models.Aula;
import com.unit17.seliganatrilha.models.Link;
import com.unit17.seliganatrilha.repositories.LinkRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class LinkServiceImpl implements  LinkService{

    final LinkRepository linkRepository;
    final AulaService aulaService;

    public LinkServiceImpl(LinkRepository linkRepository, AulaService aulaService) {
        this.linkRepository = linkRepository;
        this.aulaService = aulaService;
    }


    @Transactional
    public void save(UUID aulaId, String novoLink) {
        Link link = new Link(novoLink);
        Aula aula = aulaService.findById(aulaId);
        link.setAula(aula);
        linkRepository.save(link);
    }

    @Transactional
    public void update(UUID id, String novoLink) {
        Optional<Link> link = linkRepository.findById(id);
        if(link.isEmpty()) {
            throw new RuntimeException();
        }
        Link antigoLink = link.get();
        antigoLink.setLink(novoLink);
    }

    @Transactional
    public void delete(UUID id) {
        if(!linkRepository.existsById(id)) {
            throw new RuntimeException();
        }
        linkRepository.deleteById(id);
    }
}
