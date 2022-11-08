package com.unit17.seliganatrilha.controllers;

import com.unit17.seliganatrilha.exceptions.TemaNaoEncontradoException;
import com.unit17.seliganatrilha.models.Aula;
import com.unit17.seliganatrilha.models.Tema;
import com.unit17.seliganatrilha.models.Trilha;
import com.unit17.seliganatrilha.service.TemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/tema")
public class TemaController {

    final TemaService temaService;

    public TemaController(TemaService temaService) {
        this.temaService = temaService;
    }

    @GetMapping
    public ResponseEntity<Object> findByNome(@RequestParam(required = false) String nome) {
        if(nome == null){
            return ResponseEntity.status(HttpStatus.OK).body(temaService.findAll());
        }
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(temaService.findByNome(nome));
        } catch (TemaNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/aulas")
    public List<Aula> findById(@PathVariable(value = "id") UUID id) {
        return temaService.findAulas(id);
    }

    @GetMapping("/{id}/trilhas")
    public List<Trilha> findTrilhas(@PathVariable(value = "id")UUID id) {
        return temaService.findTrilhas(id);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody String tema) {
        try {
            temaService.save(tema);
        } catch (TemaNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<String> update(@PathVariable (value = "id") UUID id, @RequestBody String nome) {
        try {
            temaService.update(id, nome);
        } catch (TemaNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable (value = "id") UUID id) {
        try {
            temaService.delete(id);
        } catch (TemaNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
