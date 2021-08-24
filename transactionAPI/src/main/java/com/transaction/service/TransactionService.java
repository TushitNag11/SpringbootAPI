package com.transaction.service;

import com.transaction.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);

    Transaction getBalance(String accountNumber);
}
