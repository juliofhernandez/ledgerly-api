package com.juliofhernandez.ledgerlyapi.dto;

/**
 * DTO for {@link com.juliofhernandez.ledgerlyapi.entity.User}
 */
public record UserSummaryDTO(
    Long id,
    String firstName,
    String lastName,
    String email,
    String defaultCurrency,
    String timezone
){}