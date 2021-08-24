package com.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>, JpaSpecificationExecutor {
    @Query(nativeQuery = true, value = "SELECT * FROM transactions.transaction where account_number=:accountNumber order by transaction_time desc LIMIT 1")
    Transaction findByAccountNumber(String accountNumber);
}
