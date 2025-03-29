package br.com.feltex.desafioitau.controller;

import br.com.feltex.desafioitau.dto.TransactionDTO;
import br.com.feltex.desafioitau.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    @Autowired
    private TransactionService service;

    //Post
    @PostMapping
    public ResponseEntity<Void> createTranstion(@Valid @RequestBody TransactionDTO dto) {
        service.createTransaction(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Delete
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
        return ResponseEntity.ok().build();
    }
}
