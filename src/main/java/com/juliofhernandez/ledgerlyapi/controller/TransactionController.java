package com.juliofhernandez.ledgerlyapi.controller;

import com.juliofhernandez.ledgerlyapi.dto.TransactionResponseDTO;
import com.juliofhernandez.ledgerlyapi.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactions(){
        List<TransactionResponseDTO> response = transactionService.getAllTransactions();
        return ResponseEntity.ok(response);
    }
}
