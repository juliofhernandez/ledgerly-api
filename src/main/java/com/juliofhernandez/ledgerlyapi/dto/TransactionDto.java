package com.juliofhernandez.ledgerlyapi.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.juliofhernandez.ledgerlyapi.entity.Transaction}
 */
@Value
public class TransactionDto implements Serializable {
    Long id;
    UserDto user;
    CategoryDto category;
    String type;
    BigDecimal amount;
    String description;
    LocalDate transactionDate;
    LocalDate createdAt;
    LocalDate updatedAt;
}