package com.juliofhernandez.ledgerlyapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.juliofhernandez.ledgerlyapi.entity.Transaction}
 */
public record TransactionResponseDTO (
    Long id,
    UserSummaryDTO user,
    CategorySummaryDTO category,
    String type,
    BigDecimal amount,
    String description,
    LocalDateTime transactionDate
){}