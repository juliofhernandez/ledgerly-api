package com.juliofhernandez.ledgerlyapi.dto;

import com.juliofhernandez.ledgerlyapi.entity.Category;

/**
 * DTO for {@link Category}
 */
public record CategorySummaryDTO(
    Long id,
    String name,
    String description
) {

}