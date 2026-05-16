package com.juliofhernandez.ledgerlyapi.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.juliofhernandez.ledgerlyapi.entity.Budget}
 */
@Value
public class BudgetDto implements Serializable {
    Long id;
    UserSummaryDto user;
    CategorySummaryDto category;
    BigDecimal amountLimit;
    Integer month;
    Integer year;
}