package com.unit17.seliganatrilha.controllers;

import com.unit17.seliganatrilha.repositories.TrilhaRepository;
import com.unit17.seliganatrilha.models.Trilha;
import com.unit17.seliganatrilha.dtos.TrilhaDto;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/trilha")
public class TrilhaController {
    
    @Autowired
    private TrilhaRepository trilhaRepository;

    @GetMapping
    public List<Trilha> findAll(){
        return trilhaRepository.findAll();
    }

    @GetMapping("/trilha/{idTrilha}")
    public TrilhaRepository findById(UUID id){
        return trilhaRepository.findById(id);
    }
    
    @PostMapping
    public String save(@RequestBody TrilhaDto trilhaNova){
        return "Trilha criada com sucesso.";
    }

    @PutMapping
    public String update(@RequestBody TrilhaDto trilhaAtualizar){
        return "Trilha atualizada com sucesso.";
    }
    
    @DeleteMapping
    public String delete(@RequestBody TrilhaDto trilhaDeletar){
        return "Trilha deletada com sucesso.";
    }
}
