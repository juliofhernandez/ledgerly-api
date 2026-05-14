package com.juliofhernandez.ledgerlyapi.dto;

import com.juliofhernandez.ledgerlyapi.entity.Category;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Category}
 */
@Value
public class CategoryDto implements Serializable {
    Long id;
    UserDto user;
    String name;
    String description;
    String color;
    Boolean active;
    LocalDate createdAt;
    LocalDate updatedAt;
}