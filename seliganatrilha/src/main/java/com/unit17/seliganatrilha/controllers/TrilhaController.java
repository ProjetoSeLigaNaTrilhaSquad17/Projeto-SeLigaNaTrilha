package com.unit17.seliganatrilha.controllers;

import com.unit17.seliganatrilha.dtos.TrilhaDto;
import com.unit17.seliganatrilha.exceptions.TrilhaNaoEncontradaException;
import com.unit17.seliganatrilha.models.Trilha;

import java.util.List;
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
    public List<Trilha> findAll(){
        return trilhaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> findById(@PathVariable (value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(trilhaService.findById(id));
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<String> save(@PathVariable (value = "id") UUID id, @RequestBody TrilhaDto trilhaNova){
        trilhaService.save(trilhaNova, id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Trilha cadastrada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable (value = "id") UUID id, @RequestBody TrilhaDto trilhaAtualizar){
        try {
            trilhaService.update(id, trilhaAtualizar);
        } catch (TrilhaNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable (value = "id") UUID id){
        try {
            trilhaService.delete(id);
        } catch (TrilhaNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
