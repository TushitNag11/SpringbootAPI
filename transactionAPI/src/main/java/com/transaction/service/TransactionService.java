package com.transaction.service;

import com.transaction.model.Transaction;
import com.transaction.model.TransactionType;

import java.util.Date;
import java.util.List;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);

    Transaction getBalance(String accountNumber);

    Transaction getTransactionsByType(String accountNumber, TransactionType type);

    List<Transaction> getTransactionsByDate(String accountNumber,Date startDate, Date endDate);
}
