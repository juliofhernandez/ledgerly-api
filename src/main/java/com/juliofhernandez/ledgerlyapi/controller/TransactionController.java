package com.juliofhernandez.ledgerlyapi.controller;

import com.juliofhernandez.ledgerlyapi.dto.CreateTransactionRequestDTO;
import com.juliofhernandez.ledgerlyapi.dto.TransactionResponseDTO;
import com.juliofhernandez.ledgerlyapi.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@Valid @RequestBody CreateTransactionRequestDTO request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(transactionService.createTransaction(request));
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactions(){
        List<TransactionResponseDTO> response = transactionService.getAllTransactions();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> getTransactionById(@PathVariable Long id){
        TransactionResponseDTO response = transactionService.getTransactionById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionById(@PathVariable Long id){
        transactionService.deleteTransactionById(id);
        return ResponseEntity.noContent().build();
    }
}
