package com.unit17.seliganatrilha.controllers;

import com.unit17.seliganatrilha.dtos.TrilhaDto;
import com.unit17.seliganatrilha.exceptions.TrilhaNaoEncontradaException;
import com.unit17.seliganatrilha.models.Avaliacao;
import com.unit17.seliganatrilha.models.Trilha;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.unit17.seliganatrilha.service.TrilhaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/trilha")
public class TrilhaController {

    final TrilhaService trilhaService;

    public TrilhaController(TrilhaService trilhaService) {
        this.trilhaService = trilhaService;
    }

    @GetMapping
    public ResponseEntity<Object> findByName(@RequestParam(required = false) String nome){
        if (nome == null) {
            return ResponseEntity.status(HttpStatus.OK).body(trilhaService.findAll());
        }
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(trilhaService.findByName(nome));
        } catch (TrilhaNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> findById(@PathVariable (value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(trilhaService.findById(id));
    }

    @GetMapping("/{id}/avaliacoes")
    public Set<Avaliacao> findAvaliacoes(@PathVariable(value = "id") UUID id){
        return trilhaService.findAvaliacoes(id);
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<String> save(@PathVariable (value = "id") UUID usuarioId, @RequestBody TrilhaDto trilhaNova){
        trilhaService.save(trilhaNova, usuarioId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Trilha cadastrada com sucesso"); //HTTP return 201 - CREATED
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable (value = "id") UUID id, @RequestBody TrilhaDto trilhaAtualizar){
        try {
            trilhaService.update(id, trilhaAtualizar);
        } catch (TrilhaNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //HTTP returns 404 - NOT_FOUND
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build(); //HTTP returns 202 - Accepted
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable (value = "id") UUID id){
        try {
            trilhaService.delete(id);
        } catch (TrilhaNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //HTTP returns 404 - NOT_FOUND
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //HTTP returns 204 - NO_CONTENT
    }

}
