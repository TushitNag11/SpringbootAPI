package com.transaction.repository;

import com.transaction.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>, JpaSpecificationExecutor {

    @Query(nativeQuery = true, value = "SELECT * FROM transactions.transaction where account_number=:accountNumber order by transaction_time desc LIMIT 1")
    Transaction findByAccountNumber(String accountNumber);


    @Query(nativeQuery = true,value = "SELECT * FROM transactions.transaction where account_number =:accountNumber and transaction_type =:type")
    Transaction findByTransactionType(String accountNumber, TransactionType type);

    @Query(nativeQuery = true,value = "SELECT * FROM transactions.transaction where account_number =:accountNumber and transaction_time BETWEEN :startDate AND :endDate")
    List<Transaction> findByTransactionDate(String accountNumber, Date startDate, Date endDate);
}
