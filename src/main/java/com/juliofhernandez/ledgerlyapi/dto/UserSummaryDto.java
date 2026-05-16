package com.juliofhernandez.ledgerlyapi.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.juliofhernandez.ledgerlyapi.entity.User}
 */
public record UserSummaryDto (
    Long id,
    String firstName,
    String lastName,
    String email,
    String defaultCurrency,
    String timezone
){}