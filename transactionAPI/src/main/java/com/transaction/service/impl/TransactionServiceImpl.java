package com.transaction.service.impl;

import com.transaction.exception.ResourceNotFoundException;
import com.transaction.model.TransactionType;
import org.springframework.stereotype.Service;

import com.transaction.model.Transaction;
import com.transaction.repository.TransactionRepository;
import com.transaction.service.TransactionService;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

	
	private TransactionRepository  transactionRepository;
	
	
	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}


	@Override
	public Transaction saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction getBalance(String accountNumber) {
		Transaction transaction;
		 transaction = transactionRepository.findByAccountNumber(accountNumber);
		 if(transaction == null)
		 {
		 	throw new ResourceNotFoundException("transaction","accountNumber",accountNumber);
		 }
		 else
		 	return transaction;
	}

	@Override
	public Transaction getTransactionsByType(String accountNumber, TransactionType type) {

		Transaction  transactionList;

		transactionList = transactionRepository.findByTransactionType(accountNumber,type);

		return transactionList;
	}

	@Override
	public List<Transaction> getTransactionsByDate(String accountNumber, Date startDate, Date endDate) {
		List<Transaction> transactionList;

		transactionList = transactionRepository.findByTransactionDate(accountNumber,startDate,endDate);

		return transactionList;
	}


}
