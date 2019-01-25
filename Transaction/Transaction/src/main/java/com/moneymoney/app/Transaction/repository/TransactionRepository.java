package com.moneymoney.app.Transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moneymoney.app.Transaction.Details.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
