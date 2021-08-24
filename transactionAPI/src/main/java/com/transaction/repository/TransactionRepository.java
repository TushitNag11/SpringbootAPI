package com.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
