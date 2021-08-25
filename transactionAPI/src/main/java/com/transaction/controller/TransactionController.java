package com.transaction.controller;

import com.transaction.model.TransactionType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.transaction.model.Transaction;
import com.transaction.service.TransactionService;

import javax.sound.midi.SysexMessage;
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
    public int getTransactions(@RequestParam(name = "accountNumber") String accountNum, @RequestParam(name = "action") TransactionType type){

        Transaction transaction = transactionService.getTransactionsByType(accountNum,TransactionType.WITHDRAW);

      return transaction.getId();
    }

    @RequestMapping("/getbydates")
    public List<Transaction> getByDate(@RequestParam(name = "accNum") String accountNum,@RequestParam("sd") @DateTimeFormat(pattern = "dd.MM.yyyy") Date startDate,@RequestParam("ed") @DateTimeFormat(pattern = "dd.MM.yyyy") Date endDate){

        System.out.println("STARTDATE -  "+startDate.toString());
        System.out.println("ENDDATE  - "+endDate);
        return transactionService.getTransactionsByDate(accountNum,startDate,endDate);

    }
}
