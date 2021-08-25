package com.transaction.controller;

import com.transaction.model.TransactionType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.transaction.model.Transaction;
import com.transaction.service.TransactionService;
import java.util.Date;
import java.util.List;


@RestController

public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/savetransaction")
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<Transaction>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);

    }

        @RequestMapping("/getbalance")
    public double getBalance(@RequestParam(name = "accountNumber") String accountNum) {

        Transaction transaction = transactionService.getBalance(accountNum);

        return transaction.getBalance();


    }

    @RequestMapping("/gettransactions")
    public List<Transaction> getTransactions(@RequestParam(name = "accountNumber") String accountNum, @RequestParam(name = "action") TransactionType type){


      return transactionService.getTransactionsByType(accountNum,type);
    }

    @RequestMapping("/getbydates")
    public List<Transaction> getByDate(@RequestParam(name = "accNum") String accountNum, @RequestParam(name = "sd")@DateTimeFormat(pattern="yyyy-mm-dd") Date startDate,@RequestParam(name = "ed")@DateTimeFormat(pattern="yyyy-mm-dd") Date endDate){

        return transactionService.getTransactionsByDate(accountNum,startDate,endDate);

    }
}
