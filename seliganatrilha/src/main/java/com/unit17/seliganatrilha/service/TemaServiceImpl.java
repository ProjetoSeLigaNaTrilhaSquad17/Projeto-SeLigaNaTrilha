package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.exceptions.TemaNaoEncontradoException;
import com.unit17.seliganatrilha.models.Aula;
import com.unit17.seliganatrilha.models.Tema;
import com.unit17.seliganatrilha.models.Trilha;
import com.unit17.seliganatrilha.repositories.TemaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TemaServiceImpl implements TemaService {

    final TemaRepository temaRepository;


    public TemaServiceImpl(TemaRepository temaRepository) {
        this.temaRepository = temaRepository;
    }

    @Override
    public List<Tema> findAll() {
        return temaRepository.findAll();
    }

    @Override
    public Tema findById(UUID id) {
        Optional<Tema> tema = temaRepository.findById(id);
        if(tema.isEmpty()) {
            throw new TemaNaoEncontradoException();
        }
        return tema.get();
    }

    @Override
    public List<Tema> findByNome(String nome) {
        List<Tema> temas = temaRepository.findByNomeContaining(nome);
        if(temas.isEmpty()) {
            throw new TemaNaoEncontradoException();
        }
        return temas;
    }

    @Override
    public List<Aula> findAulas(UUID id) {
        return findById(id).getAulas();
    }

    @Override
    public List<Trilha> findTrilhas(UUID id) {
        Tema tema = findById(id);
        List<Trilha> trilhas = new ArrayList<>();
        tema.getAulas().forEach(aula -> trilhas.add(aula.getTrilha()));
        return trilhas;
    }

    @Transactional
    public void save(String novoTema) {
        temaRepository.save(new Tema(novoTema));
    }

    @Transactional
    public void update(UUID id, String novoTema) {
        Optional<Tema> tema = temaRepository.findById(id);
        if(tema.isEmpty()) {
            throw new TemaNaoEncontradoException();
        }
        Tema antigoTema = tema.get();
        antigoTema.setNome(novoTema);
    }

    @Transactional
    public void delete(UUID id) {
        if(!temaRepository.existsById(id)) {
            throw new TemaNaoEncontradoException();
        }
        temaRepository.deleteById(id);
    }
}
