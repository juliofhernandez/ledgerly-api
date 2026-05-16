package com.juliofhernandez.ledgerlyapi.dto;

import com.juliofhernandez.ledgerlyapi.entity.Category;

import java.time.LocalDate;

/**
 * DTO for {@link Category}
 */
public record CategorySummaryDto(
    Long id,
    String name,
    String description
) {

}