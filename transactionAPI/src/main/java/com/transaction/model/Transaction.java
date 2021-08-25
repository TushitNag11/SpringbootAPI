package com.transaction.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name="transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="account_number",nullable = false)
	private String accountNumber;
	
	@Column(name = "balance")
	private double Balance;
	
	@Column(name = "transaction_type")
	private TransactionType transactionType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "transaction_time",nullable = false)
	private Date transactionTime;
	
	@PrePersist
	private void onCreate() {
		transactionTime = new Date();
	}
	
	
}
