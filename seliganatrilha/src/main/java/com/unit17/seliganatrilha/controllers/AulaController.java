package com.unit17.seliganatrilha.controllers;

import com.unit17.seliganatrilha.dtos.AulaDto;
import com.unit17.seliganatrilha.dtos.TrilhaDto;
import com.unit17.seliganatrilha.exceptions.AulaNaoEncontradaException;
import com.unit17.seliganatrilha.exceptions.TrilhaNaoEncontradaException;
import com.unit17.seliganatrilha.service.AulaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/aula")
public class AulaController {

    final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable (value = "id")UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(aulaService.findById(id));
        } catch (AulaNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/{trilhaId}")
    public ResponseEntity<String> save(@PathVariable (value = "trilhaId") UUID trilhaId, @RequestBody AulaDto aulaNova) {
        aulaService.save(trilhaId, aulaNova);
        return ResponseEntity.status(HttpStatus.CREATED).body("Aula cadastrada com sucesso");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable (value = "id") UUID id, @RequestBody AulaDto aulaAtualizar) {
        try {
            aulaService.update(id, aulaAtualizar);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //HTTP returns 404 - NOT_FOUND
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable (value = "id") UUID id){
        try {
            aulaService.delete(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //HTTP returns 404 - NOT_FOUND
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //HTTP returns 204 - NO_CONTENT
    }
}
