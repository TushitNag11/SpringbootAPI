package com.transaction.service.impl;

import org.springframework.stereotype.Service;

import com.transaction.model.Transaction;
import com.transaction.repository.TransactionRepository;
import com.transaction.service.TransactionService;

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

}
