package com.unit17.seliganatrilha.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.unit17.seliganatrilha.models.Avaliacao;
import com.unit17.seliganatrilha.dtos.AvaliacaoDto;
import com.unit17.seliganatrilha.exceptions.AvaliacaoNaoEncontradaException;
import com.unit17.seliganatrilha.repositories.AvaliacaoRepository;;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService{
    
    final AvaliacaoRepository avaliacaoRepository;
    public AvaliacaoServiceImpl(AvaliacaoRepository avaliacaoRepository){
            this.avaliacaoRepository = avaliacaoRepository;
    }

    @Override
    public List<Avaliacao> findall(){
        return avaliacaoRepository.findAll();
    }

    @Transactional
    public void save(AvaliacaoDto novaAvaliacaoDto){
        avaliacaoRepository.save(novaAvaliacaoDto.convertToAvaliacao())
    }

    @Transactional
    public void update(UUID id, AvaliacaoDto avaliacaoAtualizar){
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findAllById(id);
        if(Avaliacao.isEmpty()){
            throw new AvaliacaoNaoEncontradaException()
        }
        Avaliacao antigaAvaliacao = avaliacao.get();
        antigaAvaliacao.setNota(avaliacaoAtualizar.getNota());
        antigaAvaliacao.setComentario(avaliacaoAtualizar.getComentario());
    }

    @Transactional
    public void delete(UUID id){
        if(avaliacaoRepository.findById(id).isEmpty){
            throw new AvaliacaoNaoEncontradaException();
        }
        avaliacaoRepository.deleteById(id);
    }

}