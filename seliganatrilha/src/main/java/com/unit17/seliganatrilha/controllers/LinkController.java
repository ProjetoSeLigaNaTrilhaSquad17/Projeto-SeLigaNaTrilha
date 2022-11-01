package com.unit17.seliganatrilha.controllers;

import com.unit17.seliganatrilha.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/link")
public class LinkController {

    final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/{aulaId}")
    public ResponseEntity<String> save(@PathVariable(value = "aulaId") UUID aulaId, @RequestBody String linkNovo) {
        linkService.save(aulaId, linkNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Link cadastrada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable (value = "id") UUID id, @RequestBody String linkAtualizar) {
        try {
            linkService.update(id, linkAtualizar);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //HTTP returns 404 - NOT_FOUND
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable (value = "id") UUID id){
        try {
            linkService.delete(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //HTTP returns 404 - NOT_FOUND
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //HTTP returns 204 - NO_CONTENT
    }
}
