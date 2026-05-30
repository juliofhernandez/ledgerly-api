package com.juliofhernandez.ledgerlyapi.service;

import com.juliofhernandez.ledgerlyapi.dto.CategorySummaryDTO;
import com.juliofhernandez.ledgerlyapi.dto.CreateTransactionRequestDTO;
import com.juliofhernandez.ledgerlyapi.dto.TransactionResponseDTO;
import com.juliofhernandez.ledgerlyapi.dto.UserSummaryDTO;
import com.juliofhernandez.ledgerlyapi.entity.Category;
import com.juliofhernandez.ledgerlyapi.entity.Transaction;
import com.juliofhernandez.ledgerlyapi.entity.User;
import com.juliofhernandez.ledgerlyapi.repository.CategoryRepository;
import com.juliofhernandez.ledgerlyapi.repository.TransactionRepository;
import com.juliofhernandez.ledgerlyapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public List<TransactionResponseDTO> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public TransactionResponseDTO createTransaction(CreateTransactionRequestDTO request) {

        User user = userRepository.findById(request.userId()).orElseThrow();
        Category category = categoryRepository.findById(request.categoryId()).orElseThrow();

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setCategory(category);
        transaction.setType(request.type());
        transaction.setAmount(request.amount());
        transaction.setDescription(request.description());
        transaction.setTransactionDate(request.transactionDate());
        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setUpdatedAt(LocalDateTime.now());

        Transaction savedTransaction = transactionRepository.save(transaction);

        return mapToResponse(savedTransaction);
    }

    public TransactionResponseDTO getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow();
        return mapToResponse(transaction);
    }

    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }

    private TransactionResponseDTO mapToResponse(Transaction transaction) {
        return new TransactionResponseDTO(
                transaction.getId(),
                new UserSummaryDTO(
                        transaction.getUser().getId(),
                        transaction.getUser().getFirstName(),
                        transaction.getUser().getLastName(),
                        transaction.getUser().getEmail(),
                        transaction.getUser().getDefaultCurrency(),
                        transaction.getUser().getTimezone()
                ),
                new CategorySummaryDTO(
                        transaction.getCategory().getId(),
                        transaction.getCategory().getName(),
                        transaction.getCategory().getDescription()
                ),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getTransactionDate()
        );
    }

}
