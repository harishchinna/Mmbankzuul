package com.moneymoney.app.Transaction.service;

import java.time.LocalDateTime;
import java.util.List;

import com.moneymoney.app.Transaction.Details.Transaction;

public interface TransactionService {

	Double deposit(Integer accountNumber, String transactionDetails, Double currentBalance, Double amount,
			LocalDateTime transactionDate);

	Double withdraw(Integer accountNumber, String transactionDetails, Double currentBalance, Double amount,
			LocalDateTime now);
	
	List<Transaction> listOfTransactions();

}
