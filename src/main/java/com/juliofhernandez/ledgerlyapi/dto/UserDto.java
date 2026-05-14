package com.juliofhernandez.ledgerlyapi.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.juliofhernandez.ledgerlyapi.entity.User}
 */
@Value
public class UserDto implements Serializable {
    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
    String defaultCurrency;
    String timezone;
    LocalDate createdAt;
    LocalDate updatedAt;
}