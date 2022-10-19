package com.unit17.seliganatrilha.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import com.unit17.seliganatrilha.models.Trilha;
import com.unit17.seliganatrilha.models.Usuario;
import org.springframework.stereotype.Service;

import com.unit17.seliganatrilha.models.Avaliacao;
import com.unit17.seliganatrilha.dtos.AvaliacaoDto;
import com.unit17.seliganatrilha.exceptions.AvaliacaoNaoEncontradaException;
import com.unit17.seliganatrilha.repositories.AvaliacaoRepository;;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService{

    final AvaliacaoRepository avaliacaoRepository;

    final UsuarioService usuarioService;

    final TrilhaService trilhaService;
    public AvaliacaoServiceImpl(AvaliacaoRepository avaliacaoRepository, UsuarioService usuarioService, TrilhaService trilhaService){
        this.avaliacaoRepository = avaliacaoRepository;
        this.usuarioService = usuarioService;
        this.trilhaService = trilhaService;
    }

    @Override
    public List<Avaliacao> findAll(){
        return avaliacaoRepository.findAll();
    }

    @Transactional
    public void save(AvaliacaoDto novaAvaliacaoDto, UUID trilhaId){
        Trilha trilha = trilhaService.findById(trilhaId);
        Avaliacao avaliacao = novaAvaliacaoDto.convertToAvaliacao();
        avaliacao.setTrilha(trilha);
        avaliacaoRepository.save(avaliacao);
    }

    @Transactional
    public void update(UUID id, AvaliacaoDto avaliacaoAtualizar){
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);
        if(avaliacao.isEmpty()){
            throw new AvaliacaoNaoEncontradaException();
        }
        Avaliacao antigaAvaliacao = avaliacao.get();
        antigaAvaliacao.setNota(avaliacaoAtualizar.getNota());
        antigaAvaliacao.setComentario(avaliacaoAtualizar.getComentario());
    }

    @Transactional
    public void delete(UUID id){
        if(avaliacaoRepository.findById(id).isEmpty()){
            throw new AvaliacaoNaoEncontradaException();
        }
        avaliacaoRepository.deleteById(id);
    }

}