package com.juliofhernandez.ledgerlyapi.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.juliofhernandez.ledgerlyapi.entity.Transaction}
 */
public record TransactionResponseDTO (
    Long id,
    UserSummaryDto user,
    CategorySummaryDto category,
    String type,
    BigDecimal amount,
    String description,
    LocalDate transactionDate
){}