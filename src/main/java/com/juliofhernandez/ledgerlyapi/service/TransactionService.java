package com.juliofhernandez.ledgerlyapi.service;

import com.juliofhernandez.ledgerlyapi.dto.CategorySummaryDto;
import com.juliofhernandez.ledgerlyapi.dto.TransactionResponseDTO;
import com.juliofhernandez.ledgerlyapi.dto.UserSummaryDto;
import com.juliofhernandez.ledgerlyapi.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<TransactionResponseDTO> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(transaction -> new TransactionResponseDTO(
                        transaction.getId(),
                        new UserSummaryDto(
                                transaction.getUser().getId(),
                                transaction.getUser().getFirstName(),
                                transaction.getUser().getLastName(),
                                transaction.getUser().getEmail(),
                                transaction.getUser().getDefaultCurrency(),
                                transaction.getUser().getTimezone()
                        ),
                        new CategorySummaryDto(
                                transaction.getCategory().getId(),
                                transaction.getCategory().getName(),
                                transaction.getCategory().getDescription()
                        ),
                        transaction.getType(),
                        transaction.getAmount(),
                        transaction.getDescription(),
                        transaction.getTransactionDate()
                ))
                .toList();
    }
}
