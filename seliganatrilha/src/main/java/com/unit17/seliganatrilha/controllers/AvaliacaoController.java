package com.unit17.seliganatrilha.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.unit17.seliganatrilha.dtos.AvaliacaoDto;
import com.unit17.seliganatrilha.models.Avaliacao;
import com.unit17.seliganatrilha.service.AvaliacaoService;
import com.unit17.seliganatrilha.exceptions.AvaliacaoNaoEncontradaException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService){
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public List<Avaliacao> findAll(){
        return avaliacaoService.findAll();
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> save(@PathVariable(value = "id") UUID id, @RequestBody AvaliacaoDto novaAvaliacao){
        avaliacaoService.save(novaAvaliacao, id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sua avaliação foi realizada com sucesso"); //HTTP return 201 - CREATED
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable(value = "id") UUID id, @RequestBody AvaliacaoDto avaliacaoAtualizar){
        try {
            avaliacaoService.update(id, avaliacaoAtualizar);
        } catch (AvaliacaoNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //HTTP returns 404 - NOT_FOUND
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build(); //HTTP returns 202 - Accepted
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value="id") UUID id){
        try {
            avaliacaoService.delete(id);
        } catch (AvaliacaoNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //HTTP returns 404 - NOT_FOUND
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //HTTP returns 204 - NO_CONTENT
    }
}
