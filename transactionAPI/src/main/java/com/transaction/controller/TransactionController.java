package com.transaction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.transaction.model.Transaction;
import com.transaction.service.TransactionService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("{accountNumber}")
    public double getBalance(@PathVariable("accountNumber") String accountNum) {

        Transaction transaction = transactionService.getBalance(accountNum);

        return transaction.getBalance();



    }

}
