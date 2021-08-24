package com.transaction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.transaction.model.Transaction;
import com.transaction.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	private TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		super();
		this.transactionService = transactionService;
	}

	@PostMapping
	public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
		return new ResponseEntity<Transaction>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);

	}

}
