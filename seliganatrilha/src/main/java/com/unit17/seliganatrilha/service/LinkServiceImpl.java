package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.models.Aula;
import com.unit17.seliganatrilha.models.Link;
import com.unit17.seliganatrilha.repositories.LinkRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class LinkServiceImpl implements  LinkService{

    final LinkRepository linkRepository;

    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    @Transactional
    public void save(Aula aula, String novoLink) {
        Link link = new Link(novoLink);
        link.setAula(aula);
        linkRepository.save(link);
    }

    @Transactional
    public void update(UUID id, String novoLink) {

    }

    @Transactional
    public void delete(UUID id) {

    }
}
