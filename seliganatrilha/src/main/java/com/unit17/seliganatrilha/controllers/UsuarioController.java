package com.unit17.seliganatrilha.controllers;

import com.unit17.seliganatrilha.dtos.UsuarioDto;
import com.unit17.seliganatrilha.exceptions.UsuarioNaoEncontradoException;
import com.unit17.seliganatrilha.models.Trilha;
import com.unit17.seliganatrilha.models.Usuario;
import com.unit17.seliganatrilha.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;


@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}/trilhas")
    public Set<Trilha> findTrilhas(@PathVariable(value = "id") UUID id){
        return usuarioService.findTrilhas(id);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody UsuarioDto novoUsuario){
        usuarioService.save(novoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Novo usuário cadastrado com sucesso!"); //HTTP return 201 - CREATED
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable(value = "id") UUID id, @RequestBody UsuarioDto usuarioAtualizar){
        try {
            usuarioService.update(id, usuarioAtualizar);
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //HTTP returns 404 - NOT_FOUND
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Dados de usuário atualizados com sucesso!"); //HTTP returns 202 - Accepted
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") UUID id){
        try {
            usuarioService.delete(id);
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //HTTP returns 404 - NOT_FOUND
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário deletado com sucesso"); //HTTP returns 204 - NO_CONTENT
    }

}
