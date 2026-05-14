package com.juliofhernandez.ledgerlyapi.repository;

import com.juliofhernandez.ledgerlyapi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}