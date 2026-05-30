package com.juliofhernandez.ledgerlyapi.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateTransactionRequestDTO (
        @NotNull
        Long userId,

        @NotNull
        Long categoryId,

        String type,

        @NotNull
        @Positive
        BigDecimal amount,

        @Size(max = 255)
        String description,

        @NotNull
        @PastOrPresent
        LocalDateTime transactionDate
) {
}
